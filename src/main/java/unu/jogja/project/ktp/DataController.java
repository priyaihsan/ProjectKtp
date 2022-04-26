/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unu.jogja.project.ktp;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ican
 */
@Controller
public class DataController {

    @Autowired
    dataRepository datarepo;

    DataJpaController datactrl = new DataJpaController();
    List<Data> newData = new ArrayList<>();

    @RequestMapping("/data")
    public String getDataKTP(Model model) {
        try {
            newData = datactrl.findDataEntities();
        } catch (Exception e) {

        }
        model.addAttribute("getdata", newData);
        return "data";
    }

    @RequestMapping("/TambahData")
    public String getDataKTP() {
        return "TambahData";
    }

    @PostMapping("/TambahData/submit")
    public Data addDataKTP(@ModelAttribute("formData") Data datas) {
        datarepo.save(datas);
        return datas;

    }

}
