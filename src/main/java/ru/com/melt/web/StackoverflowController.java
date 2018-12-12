package ru.com.melt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.com.melt.model.StackoverflowWebsite;
import ru.com.melt.service.StackoverflowService;

import java.util.List;

@RestController
@RequestMapping("/api/stackoverflow")
public class StackoverflowController {
    @Autowired
    private StackoverflowService stackoverflowService;
    @RequestMapping
    public List<StackoverflowWebsite> getListOfProviders() {
        return stackoverflowService.findAll();
    }
}
