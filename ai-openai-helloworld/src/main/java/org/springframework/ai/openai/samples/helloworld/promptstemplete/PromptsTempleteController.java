package org.springframework.ai.openai.samples.helloworld.promptstemplete;

import java.util.Map;

import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.Generation;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptsTempleteController {

    private AiClient aiClient;

    @Value("classpath:/prompts/joke-prompt.st")
    private Resource jokeResource;

    @Value("classpath:/prompts/ask-prompt.st")
    private Resource askResource;

    @Autowired
    private PromptsTempleteController(AiClient aiClient){
        this.aiClient = aiClient;
    }

    @GetMapping("/ai/prompts/jokes")
    public Generation completion(@RequestParam(value="adjective",defaultValue = "funny") String adjective,
    @RequestParam(value = "topic", defaultValue = "cows") String topic){
        PromptTemplate promptTemplate = new PromptTemplate(jokeResource);
        Prompt prompt = promptTemplate.create(Map.of("adjective", adjective, "topic", topic));
        return aiClient.generate(prompt).getGeneration();
    }

    @GetMapping("/ai/prompts/anything")
    public Generation anything(@RequestParam(value="adjective",defaultValue = "earth") String adjective){
        PromptTemplate promptTemplate = new PromptTemplate(askResource);
        Prompt prompt = promptTemplate.create(Map.of("adjective", adjective));
        return aiClient.generate(prompt).getGeneration();
    }
    
}
