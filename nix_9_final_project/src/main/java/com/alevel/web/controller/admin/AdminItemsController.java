package com.alevel.web.controller.admin;

import com.alevel.facade.ItemFacade;
import com.alevel.web.controller.AbstractController;
import com.alevel.web.dto.request.ItemRequestDto;
import com.alevel.web.dto.response.ItemResponseDto;
import com.alevel.web.dto.response.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Validated
@Controller
@RequestMapping("/admin/items")
public class AdminItemsController extends AbstractController {

    private final AbstractController.HeaderName[] columnNames = new HeaderName[] {
            new HeaderName("#", null, null),
            new HeaderName("image", null, null),
            new HeaderName("item name", "itemName", "item_name"),
            new HeaderName("created", "created", "created"),
            new HeaderName("price", "price", "price"),
            new HeaderName("quantity", "quantity", "quantity"),
            new HeaderName("details", null, null),
            new HeaderName("delete", null, null)
    };

    private final ItemFacade itemFacade;

    public AdminItemsController(ItemFacade itemFacade) {
        this.itemFacade = itemFacade;
    }


    @GetMapping
    public String findAll(Model model, WebRequest request) {
        PageData<ItemResponseDto> response = itemFacade.findAll(request);
        initDataTable(response, columnNames, model);
        model.addAttribute("createUrl", "/admin/items/all");
        model.addAttribute("createNew", "/admin/items/new");
        model.addAttribute("cardHeader", "All Items");
        return "pages/admin/items/items_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "items");
    }

    @GetMapping("/new")
    public String redirectToNewBookPage(Model model) {
        model.addAttribute("item", new ItemRequestDto());
        return "pages/admin/items/items_new";
    }

    @PostMapping("/create")
    public String createNewDepartment(RedirectAttributes attributes, @ModelAttribute("item") ItemRequestDto dto, @RequestParam("file") MultipartFile file) {
        itemFacade.create(dto);
        return "redirect:/admin/items";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable @Min(value = 1, message = "id can not be zero") Long id) {
        itemFacade.delete(id);
        return "redirect:/admin/items";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable @NotBlank(message = "id can not be empty") String id, Model model) {
        try {
            Long itemId = Long.parseLong(id);
            ItemResponseDto dto = itemFacade.findById(itemId);
            model.addAttribute("item", dto);
            return "pages/admin/items/item_details";
        } catch (NumberFormatException e) {
            throw new NumberFormatException("incorrect value id");
        }
    }
}
