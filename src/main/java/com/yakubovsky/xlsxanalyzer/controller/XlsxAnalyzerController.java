package com.yakubovsky.xlsxanalyzer.controller;

import com.yakubovsky.xlsxanalyzer.service.XlsxAnalyzerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.yakubovsky.xlsxanalyzer.configuration.XlsxAnalyzerResourceDefinition.XLSX_ANALYZER_RESOURCE;

@RestController
@RequestMapping(path = XLSX_ANALYZER_RESOURCE)
public class XlsxAnalyzerController {

    private final XlsxAnalyzerService xlsxAnalyzerService;

    public XlsxAnalyzerController(XlsxAnalyzerService xlsxAnalyzerService) {
        this.xlsxAnalyzerService = xlsxAnalyzerService;
    }

    @Operation(summary = "Find largest number",
            description = "Find N-th largest number in the file",
            responses = {
                    @ApiResponse(responseCode = "200", description = "N-th largest number found successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("/find-nth-max")
    public ResponseEntity<Integer> findNthMaxNumber(@RequestParam String filePath, @RequestParam int n) {
        return new ResponseEntity<>(xlsxAnalyzerService.findNthMaxNumber(filePath, n), HttpStatus.OK);
    }
}