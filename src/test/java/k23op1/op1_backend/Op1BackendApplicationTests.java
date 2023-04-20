package k23op1.op1_backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import k23op1.op1_backend.web.ProductController;
import k23op1.op1_backend.web.ManufacturerController;

@SpringBootTest
class Op1BackendApplicationTests {

	@Autowired
	private ProductController productController;
	@Autowired
	private ManufacturerController manufacturerController;

	@Test
	void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
		assertThat(manufacturerController).isNotNull();
	}

}
