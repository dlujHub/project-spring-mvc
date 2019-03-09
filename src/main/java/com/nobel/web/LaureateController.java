package com.nobel.web;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.nobel.model.Laureate;
import com.nobel.validator.LaureateFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nobel.service.LaureateService;

@Controller
public class LaureateController {

    private LaureateService laureateService;

    @Autowired
    LaureateFormValidator laureateFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(laureateFormValidator);
    }

    @Autowired
    public void setLaureateService(LaureateService laureateService) {
        this.laureateService = laureateService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/laureates";
    }

    // list of laureates
    @RequestMapping(value = "/laureates", method = RequestMethod.GET)
    public String showAllLaureates(Model model) {

        model.addAttribute("laureates", laureateService.findAll());
        return "laureates/listAll";

    }

    // laureates per capita
    @RequestMapping(value = "/laureates_per_capita", method = RequestMethod.GET)
    public String showLaureatesPerCapita(Model model) {

        model.addAttribute("countries", laureateService.laureatesPerCapita());
        return "laureates/perCapita";

    }

    // save/update
    @RequestMapping(value = "/laureates", method = RequestMethod.POST)
    public String saveOrUpdateLaureate(@ModelAttribute("laureateForm") @Validated Laureate laureate,
                                       BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            populateModel(model);
            return "laureates/laureateform";
        } else {

            laureateService.updateOrSave(laureate);

            redirectAttributes.addFlashAttribute("css", "success");
            redirectAttributes.addFlashAttribute("msg", "Information updated successfully!");

            return "redirect:/laureates/" + laureate.getId();
        }
    }

    // add
    @RequestMapping(value = "/laureates/add", method = RequestMethod.GET)
    public String showAddLaureateForm(Model model) {

        Laureate laureate = new Laureate();
        // default
        laureate.setGender("M");

        model.addAttribute("laureateForm", laureate);
        populateModel(model);
        return "laureates/laureateform";
    }

    // update
    @RequestMapping(value = "/laureates/{id}/update", method = RequestMethod.GET)
    public String showUpdateLaureateForm(@PathVariable("id") int id, Model model) {

        Laureate laureate = laureateService.findId(id);
        model.addAttribute("laureateForm", laureate);
        populateModel(model);

        return "laureates/laureateform";
    }

    // delete
    @RequestMapping(value = "/laureates/{id}/delete", method = RequestMethod.POST)
    public String deleteLaureate(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        laureateService.delete(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Laureate is deleted.");

        return "redirect:/laureates";
    }

    @RequestMapping(value = "/laureates/{id}", method = RequestMethod.GET)
    public String showLaureates(@PathVariable("id") int id, Model model) {

        Laureate laureate = laureateService.findId(id);
        if (laureate == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Laureate not found");
        }
        model.addAttribute("laureate", laureate);

        return "laureates/show";
    }

    private void populateModel(Model model) {

        List<Integer> years = new ArrayList<>();
        for (Integer i = 2019; i >= 1901; i--) {
            years.add(i);
        }
        model.addAttribute("yearList", years);

        List<String> categories = new ArrayList<>();
        categories.add("physics");
        categories.add("chemistry");
        categories.add("medicine");
        categories.add("literature");
        categories.add("peace");
        categories.add("economics");
        model.addAttribute("categoryList", categories);

        List<String> countries = new ArrayList<>();

        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            countries.add(obj.getDisplayCountry());

        }
        model.addAttribute("countryList", countries);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

        ModelAndView model = new ModelAndView();
        model.setViewName("laureates/show");
        model.addObject("msg", "laureate not found");

        return model;

    }
}