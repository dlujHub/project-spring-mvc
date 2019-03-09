package com.nobel.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nobel.model.Laureate;
import com.nobel.service.LaureateService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Component
public class LaureateFormValidator implements Validator {

    @Autowired
    LaureateService laureateService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Laureate.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Laureate laureate = (Laureate) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "NotEmpty.laureateForm.first_name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "NotEmpty.laureateForm.last_name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "born", "NotEmpty.laureateForm.born");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "born_country", "NotEmpty.laureateForm.born_country");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "born_city", "NotEmpty.laureateForm.born_city");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "NotEmpty.laureateForm.category");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motivation", "NotEmpty.laureateForm.motivation");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prize_year", "NotEmpty.laureateForm.prize_year");

        if (laureate.getDied() == null || laureate.getDied().equals("")) {
            laureate.setDied("Alive");
        }
        if(!isValidFormat(laureate.getBorn(), Locale.ENGLISH)){
            errors.rejectValue("born", "Pattern.laureateForm.born");
        }
        if(laureate.getDied() != null && !laureate.getDied().equals("Alive")
                && !isValidFormat(laureate.getDied(), Locale.ENGLISH)){
            errors.rejectValue("died", "Pattern.laureateForm.died");
        }

    }

    private boolean isValidFormat(String value, Locale locale) {
        LocalDateTime ldt;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", locale);

        try {
            ldt = LocalDateTime.parse(value, formatter);
            String result = ldt.format(formatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, formatter);
                String result = ld.format(formatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, formatter);
                    String result = lt.format(formatter);
                    return result.equals(value);
                } catch (DateTimeParseException ignored) {

                }
            }
        }

        return false;
    }
}