package k23op1.op1_backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import k23op1.op1_backend.web.ClothingController;
import k23op1.op1_backend.web.ManufacturerController;

@ExtendWith(SpringExtension.class)
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
