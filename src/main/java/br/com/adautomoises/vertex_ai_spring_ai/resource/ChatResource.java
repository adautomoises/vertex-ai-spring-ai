package br.com.adautomoises.vertex_ai_spring_ai.resource;

import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerar")
public class ChatResource {

    private final VertexAiGeminiChatModel chatModel;

    @Autowired
    public ChatResource(VertexAiGeminiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping()
    public String gerarTexto(@RequestParam(value = "texto", defaultValue = "Saudações") String texto) {
        return this.chatModel.call(texto);
    }

}
