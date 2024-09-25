package pe.edu.cibertec.T1_LuisFelixCuya_backend.service;

import pe.edu.cibertec.T1_LuisFelixCuya_backend.dto.PlacaRequestDTO;

import java.io.IOException;

public interface PlacaService {
    String[] obtenerVehiculo(PlacaRequestDTO loginRequestDTO) throws IOException;
}
