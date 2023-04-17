package k23op1.op1_backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import k23op1.op1_backend.web.ClothingController;
import k23op1.op1_backend.web.ManufacturerController;

@SpringBootTest
class Op1BackendApplicationTests {

	@Autowired
	private ClothingController clothingController;
	@Autowired
	private ManufacturerController manufacturerController;

	@Test
	void contextLoads() throws Exception {
		assertThat(clothingController).isNotNull();
		assertThat(manufacturerController).isNotNull();
	}

}
