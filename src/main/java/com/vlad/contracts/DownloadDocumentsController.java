package com.vlad.contracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class DownloadDocumentsController {
    public static final List<String> DOCUMENTS_TO_DOWNLOAD =
            Arrays.asList("23567e24f52746ef92c470be6059d193",
                    "4805f381d48948b1b34d6ea2daa029a3",
                    "47fa8764e1b74f4db58f84c9db460566");

    @Autowired
    private DocumentWorker documentWorker;

    @RequestMapping("/downloaddocuments")
    public String downloadDocuments() throws IOException {
        documentWorker.processDocuments(DOCUMENTS_TO_DOWNLOAD);
        return "Success. Documents were processed successfully.";
    }
}
