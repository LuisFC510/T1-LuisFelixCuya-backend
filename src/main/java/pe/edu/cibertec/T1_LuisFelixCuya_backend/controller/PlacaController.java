package pe.edu.cibertec.T1_LuisFelixCuya_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.T1_LuisFelixCuya_backend.dto.PlacaRequestDTO;
import pe.edu.cibertec.T1_LuisFelixCuya_backend.dto.PlacaResponseDTO;
import pe.edu.cibertec.T1_LuisFelixCuya_backend.service.PlacaService;

@RestController
@RequestMapping("/buscarPlaca")
public class PlacaController {

    @Autowired
    PlacaService placaService;

    @PostMapping("/placa")
    public PlacaResponseDTO consultarPlaca(@RequestBody PlacaRequestDTO placaRequestDTO){

        try {

            String[] datosCarros = placaService.obtenerVehiculo(placaRequestDTO);
            if (datosCarros == null) {
                return new PlacaResponseDTO("01", "Error: Placa no encontrada", "", "", "");
            }
            return new PlacaResponseDTO(datosCarros[0], datosCarros[1], datosCarros[2], datosCarros[3], datosCarros[4]);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new PlacaResponseDTO("No Encontrado", "Error: Ocurrió un problema", "", "", "");

        }
    }
}
