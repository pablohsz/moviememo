package br.edu.pucgo.moviememo.service;

import br.edu.pucgo.moviememo.model.Movie;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private MovieService movieService;

    public JasperPrint exportReport() throws IOException, JRException {
        List<Movie> movies = movieService.getAll();
        File file = ResourceUtils.getFile("classpath:movie_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(movies);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        return jasperPrint;
    }

}
