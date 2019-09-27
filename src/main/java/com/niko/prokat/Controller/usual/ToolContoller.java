package com.niko.prokat.Controller.usual;

import com.niko.prokat.Model.dto.CategoryDto;
import com.niko.prokat.Model.dto.ToolDto;
import com.niko.prokat.Service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ToolContoller {
    private final ToolService toolService;

    @GetMapping("/catalog")
    public String getCategoriesPage(@RequestParam List<Long> cat,
                                    Model model){
        CategoryDto category = toolService.getCategory(cat);
        List<String> categoryIds = cat.stream()
                .map(String::valueOf).collect(Collectors.toList());
        model.addAttribute("queryStr",String.join(",",categoryIds));

        if (category.getChildren().isEmpty()){
            List<ToolDto> tools = toolService.findTools(category.getId());
            if (tools == null){
                model.addAttribute("text","404 - Страница не найдена");
                return "text";
            }

            model.addAttribute("tools",tools);
            return "catalog";
        }
        model.addAttribute("categories",category.getChildren());
        return "catalog";
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("topTools",toolService.getTopTools());
        return "main";
    }

    @GetMapping("/tool/{toolId}")
    public String getTool(@PathVariable Long toolId,
                          Model model){
        model.addAttribute("tool",toolService.findToolById(toolId));
        return "tool";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "adminMain";
    }
}
