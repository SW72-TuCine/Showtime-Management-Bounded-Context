package com.upc.ShowTimeBD;

import com.upc.ShowTimeBD.Client.CinemaClient;
import com.upc.ShowTimeBD.Repositories.ShowTimeRepository;
import com.upc.ShowTimeBD.Service.Impl.ClasePrueba;
import com.upc.ShowTimeBD.Service.Impl.ShowTimeServiceImpl;
import com.upc.ShowTimeBD.Shared.CinemaResponse;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ShowTimeBdApplicationTests {

	@Test
	void obtenerCinemaPorId() {
		ClasePrueba clasePrueba = new ClasePrueba();
		clasePrueba.getCinemaInformationById("4");

	}

}
