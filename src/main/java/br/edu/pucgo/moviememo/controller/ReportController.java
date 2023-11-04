package br.edu.pucgo.moviememo.controller;


import br.edu.pucgo.moviememo.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/relatorio")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/pdf")
    public void generateReport(HttpServletResponse response) throws JRException, IOException {

        var jasperPrint = reportService.exportReport();
        // Exporta o relatório para PDF
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

        // Define o tipo de conteúdo da resposta
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=relatorio_filmes_avaliados.pdf");
    }

}