package pe.edu.cibertec.T1_LuisFelixCuya_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T1_LuisFelixCuya_backend.dto.PlacaRequestDTO;
import pe.edu.cibertec.T1_LuisFelixCuya_backend.service.PlacaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PlacaServiceImpl implements PlacaService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] obtenerVehiculo(PlacaRequestDTO placaRequestDTO) throws IOException {

        String[] datosCarros = null;
        Resource resource = resourceLoader.getResource("classpath:carros.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (placaRequestDTO.placa().equals(datos[1]) ) {
                    datosCarros = new String[5];
                    datosCarros[0] = datos[2];
                    datosCarros[1] = datos[3];
                    datosCarros[2] = datos[4];
                    datosCarros[3] = datos[5];
                    datosCarros[4] = datos[6];
                }

            }

        } catch (IOException e) {
            datosCarros = null;
            throw new IOException(e);
        }


        return datosCarros;
    }
}