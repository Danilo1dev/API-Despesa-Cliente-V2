package br.com.danilosilva.despesa;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
@ExtendWith(MockitoExtension.class)
class DespesaApplicationTests {
	@InjectMocks
	private DespesaApplication despesaApplication;

	@Test
	void getHomeTest() {
		despesaApplication.getHomeTest();
	}
	@Test
	void main() {
		DespesaApplication.main(new String[] {});
	}
}
