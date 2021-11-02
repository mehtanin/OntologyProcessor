package com.example.OntologyProcessor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class OntologyController {

    @GetMapping("/ongology")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Default value") String name,
            Model model) {
        model.addAttribute("name", name);
        //model.addAttribute("data", "data object here");
        
        final String uri = "https://lov.linkeddata.es/dataset/lov/api/v2/term/search?q=Person&type=class";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        //System.out.println(result);
        model.addAttribute("data", result);

        return "ontology";
    }

}