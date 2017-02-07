//package com.mobithink.server;
//
//import com.mobithink.server.DTO.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.http.MediaType;
//import org.junit.Before;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = MobithinkServerApplication.class)
//@SpringBootTest
//@ActiveProfiles("dev")
//public class MobithinkServerApplicationTests {
//
//	@Resource
//	private WebApplicationContext context;
//
//	private MockMvc restUserMockMvc;
//
//	@Before
//	public void setup() {
//
//		this.restUserMockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//	}
//
//	@Test
//	public void contextLoads() {
//	}
//
//	@Test
//	public void testSavedNewBusLineDTO() throws Exception{
//		CityDTO cityDTO = new CityDTO();
//		cityDTO.setName("Grenoble");
//		//cityDTO.setId(117L);
//
//		StationDTO station1 = new StationDTO();
//		station1.setStationName("station z1");
//		station1.setStep(0);
//		StationDTO station2 = new StationDTO();
//		station2.setStationName("station z2");
//		station2.setStep(1);
//		StationDTO station3 = new StationDTO();
//		station3.setStationName("station z3");
//		station3.setStep(2);
//
//		List<StationDTO> stationDTOList = new ArrayList<>();
//		stationDTOList.add(station1);
//		stationDTOList.add(station2);
//		stationDTOList.add(station3);
//
//		BusLineDTO busLineDTO = new BusLineDTO();
//		busLineDTO.setName("Ligne dto 14");
//		busLineDTO.setDateOfCreation(22222222L);
//		busLineDTO.setCityDto(cityDTO);
//		busLineDTO.setStationDTOList(stationDTOList);
//
//		restUserMockMvc.perform(post("/mobithink/busline/create")
//		.content(TestUtil.convertObjectToJsonBytes(busLineDTO))
//		.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				//.andExpect(content().string("exist"))
//				//.andExpect(content().string("succes"))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	public void testSavedNewTripDto() throws Exception{
//
//		EventDTO eventDTO1 = new EventDTO();
//		eventDTO1.setStationName("Station 121");
//		eventDTO1.setStartTime(111L);
//		eventDTO1.setEndTime(222L);
//		eventDTO1.setGpsLat(654L);
//		eventDTO1.setGpsLong(654L);
//		eventDTO1.setEventName("Type d'évènement");
//		EventDTO eventDTO2 = new EventDTO();
//		eventDTO2.setGpsLat(987L);
//		eventDTO2.setGpsLong(987L);
//		eventDTO2.setStartTime(111L);
//		eventDTO2.setEndTime(222L);
//		eventDTO2.setEventName("Type d'évènement");
//		List<EventDTO> eventDTOList = new ArrayList<>();
//		eventDTOList.add(eventDTO1);
//		eventDTOList.add(eventDTO2);
//
//		RollingPointDTO rollingPointDTO  = new RollingPointDTO();
//		rollingPointDTO.setGpsLat(321L);
//		rollingPointDTO.setGpsLong(321L);
//		rollingPointDTO.setPointTime(55555L);
//		rollingPointDTO.setTrafficIndex(4);
//		RollingPointDTO rollingPointDTO1  = new RollingPointDTO();
//		rollingPointDTO1.setGpsLat(963L);
//		rollingPointDTO1.setGpsLong(963L);
//		rollingPointDTO1.setPointTime(55555L);
//		rollingPointDTO1.setTrafficIndex(4);
//		List<RollingPointDTO> rollingPointDTOList = new ArrayList<>();
//		rollingPointDTOList.add(rollingPointDTO);
//		rollingPointDTOList.add(rollingPointDTO1);
//
//		StationDataDTO stationDataDTO = new StationDataDTO();
//		stationDataDTO.setStationName("Station 121");
//		stationDataDTO.setGpsLat(852L);
//		stationDataDTO.setGpsLong(852L);
//		stationDataDTO.setStartTime(111999L);
//		stationDataDTO.setEndTime(4446666L);
//		stationDataDTO.setNumberOfComeIn(6);
//		stationDataDTO.setNumberOfGoOut(8);
//		stationDataDTO.setStationStep(0);
//		StationDataDTO stationDataDTO2 = new StationDataDTO();
//		stationDataDTO2.setStationName("Station 122");
//		stationDataDTO2.setGpsLat(741L);
//		stationDataDTO2.setGpsLong(741L);
//		stationDataDTO2.setStartTime(555666L);
//		stationDataDTO2.setEndTime(999555L);
//		stationDataDTO2.setNumberOfComeIn(6);
//		stationDataDTO2.setNumberOfGoOut(8);
//		stationDataDTO2.setStationStep(1);
//		List<StationDataDTO> stationDataDTOList = new ArrayList<>();
//		stationDataDTOList.add(stationDataDTO);
//		stationDataDTOList.add(stationDataDTO2);
//
//		TripDTO tripDTO = new TripDTO();
//		tripDTO.setBusLineDtoName("Ligne DTO 1");
//		tripDTO.setCityDtoName("Toulouse");
//		tripDTO.setAtmo(5);
//		tripDTO.setStartGpsLat(951L);
//		tripDTO.setStartGpsLong(951L);
//		tripDTO.setEndGpsLat(753L);
//		tripDTO.setEndGpsLong(753L);
//		tripDTO.setStartTime(2222222L);
//		tripDTO.setEndTime(333333333L);
//		tripDTO.setTemperature(20);
//		tripDTO.setVehicleCapacity(55);
//		tripDTO.setTripName("Enregistrement 2");
//		tripDTO.setWeather("Ensoleillé");
//		tripDTO.setEventDTOList(eventDTOList);
//		tripDTO.setRollingPointDTOList(rollingPointDTOList);
//		tripDTO.setStationDataDTOList(stationDataDTOList);
//
//		restUserMockMvc.perform(post("/mobithink/trip/create")
//				.content(TestUtil.convertObjectToJsonBytes(tripDTO))
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				//.andExpect(content().string("exist"))
//				//.andExpect(content().string("succes"))
//				.andExpect(status().isOk());
//
//	}
//
//	@Test
//	public void testFindListOfTripDtoByCityAndBulineNames() throws Exception {
//		restUserMockMvc.perform(get("/mobithink/trip/find/Toulouse/LigneDTO1")
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].cityDtoName").value("Toulouse"));
//	}
//
//	@Test
//	public void testFindAllCities() throws Exception {
//		restUserMockMvc.perform(get("/mobithink/city/findAll")
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				;
//	}
//
//
//
//	@Test
//	public void testGetFindAllLinesByCity() throws Exception {
//		restUserMockMvc.perform(get("/mobithink/busline/find/Toulouse")
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].cityDto.name").value("Toulouse"))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	public void testGetFindStationAssociateWithBusLine() throws Exception{
//		restUserMockMvc.perform(get("/mobithink/station/find/199")
//		.accept(MediaType.APPLICATION_JSON))
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.[0].stationName").value("station 1"))
//				.andExpect(status().isOk());
//	}
//
//	//	@Test
////	public void testPostCreateBusLine() throws Exception{
////		City city = new City();
////		city.setId(27L);
////		city.setName("Paris");
////		BusLine busLine = new BusLine();
////		busLine.setName("ligne test");
////		busLine.setCity(city);
////		busLine.setDateOfCreation(1111111L);
////
////		restUserMockMvc.perform(post("/mobithink/busline/create")
////		.content(TestUtil.convertObjectToJsonBytes(busLine))
////		.contentType(MediaType.APPLICATION_JSON)
////				.accept(MediaType.APPLICATION_JSON))
////				//.andExpect(content().string("exist"))
////				//.andExpect(content().string("succes"))
////				.andExpect(status().isOk());
////	}
//
//
////	@Test
////	public void testGetCreateCity() throws Exception {
////		restUserMockMvc.perform(get("/mobithink/city/create/test")
////				.accept(MediaType.APPLICATION_JSON))
////				//.andExpect(content().string("exist"))
////				//.andExpect(content().string("succes"))
////				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
////				.andExpect(status().isOk());
////
////	}
//}
