package com.mobithink.server;

import com.mobithink.server.DTO.BusLineDTO;
import com.mobithink.server.DTO.CityDTO;
import com.mobithink.server.DTO.StationDTO;
import com.mobithink.server.entity.BusLine;
import com.mobithink.server.entity.City;
import com.mobithink.server.entity.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.junit.Before;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MobithinkServerApplication.class)
@SpringBootTest
@ActiveProfiles("dev")
public class MobithinkServerApplicationTests {

	@Resource
	private WebApplicationContext context;

	private MockMvc restUserMockMvc;

	@Before
	public void setup() {

		this.restUserMockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSavedNewBusLineDTO() throws Exception{
		CityDTO cityDTO = new CityDTO();
		cityDTO.setName("Toulouse");

		StationDTO station1 = new StationDTO();
		station1.setStationName("station 1");
		StationDTO station2 = new StationDTO();
		station2.setStationName("station 2");
		StationDTO station3 = new StationDTO();
		station3.setStationName("station 3");

		List<StationDTO> stationDTOList = new ArrayList<>();
		stationDTOList.add(station1);
		stationDTOList.add(station2);
		stationDTOList.add(station3);

		BusLineDTO busLineDTO = new BusLineDTO();
		busLineDTO.setName("Ligne dto 3");
		busLineDTO.setDateOfCreation(22222222L);
		busLineDTO.setCityDto(cityDTO);
		busLineDTO.setStationDTOList(stationDTOList);

		restUserMockMvc.perform(post("/mobithink/busline/create")
		.content(TestUtil.convertObjectToJsonBytes(busLineDTO))
		.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				//.andExpect(content().string("exist"))
				//.andExpect(content().string("succes"))
				.andExpect(status().isOk());
}

	@Test
	public void testFindAllCities() throws Exception {
		ResultActions result = restUserMockMvc.perform(get("/mobithink/city/findAll")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				;
	}



	@Test
	public void testGetFindAllLinesByCity() throws Exception {
		restUserMockMvc.perform(get("/mobithink/busline/find/Paris")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].cityDto.name").value("Paris"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetFindStationAssociateWithCity() throws Exception{
		restUserMockMvc.perform(get("/mobithink/station/find/70")
		.accept(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].stationName").value("station 1"))
				.andExpect(status().isOk());
	}

	//	@Test
//	public void testPostCreateBusLine() throws Exception{
//		City city = new City();
//		city.setId(27L);
//		city.setName("Paris");
//		BusLine busLine = new BusLine();
//		busLine.setName("ligne test");
//		busLine.setCity(city);
//		busLine.setDateOfCreation(1111111L);
//
//		restUserMockMvc.perform(post("/mobithink/busline/create")
//		.content(TestUtil.convertObjectToJsonBytes(busLine))
//		.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				//.andExpect(content().string("exist"))
//				//.andExpect(content().string("succes"))
//				.andExpect(status().isOk());
//	}


//	@Test
//	public void testGetCreateCity() throws Exception {
//		restUserMockMvc.perform(get("/mobithink/city/create/test")
//				.accept(MediaType.APPLICATION_JSON))
//				//.andExpect(content().string("exist"))
//				//.andExpect(content().string("succes"))
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andExpect(status().isOk());
//
//	}
}
