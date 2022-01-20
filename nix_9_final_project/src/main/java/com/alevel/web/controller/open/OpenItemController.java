package com.alevel.web.controller.open;

import com.alevel.facade.PLPFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/items")
public class OpenItemController {
    private final PLPFacade plpFacade;

    public OpenItemController(PLPFacade plpFacade) {
        this.plpFacade = plpFacade;
    }
//    private final SearchItemFacade searchItemFacade;

    @GetMapping
    private String allItems(Model model, WebRequest webRequest) {
        model.addAttribute("itemList", plpFacade.search(webRequest));
        return "pages/open/plp";
    }

    @PostMapping("/search")
    private String allBooksSearch(
            RedirectAttributes redirectAttributes, @RequestParam String itemSearch) {
        redirectAttributes.addAttribute("itemSearch", itemSearch);
        return "redirect:/items";
    }

//    @GetMapping("/suggestions")
//    @ResponseBody
//    public List<String> fetchSuggestions(@RequestParam(value = "q", required = false) String query) {
//        System.out.println("OpenBookController.fetchSuggestions: " + query);
//        return searchBookFacade.fetchSuggestions(query);
//    }
}
