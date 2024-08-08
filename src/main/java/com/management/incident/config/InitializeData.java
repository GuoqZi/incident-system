package com.management.incident.config;

import com.management.incident.model.entities.Incident;
import com.management.incident.repository.IncidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class InitializeData implements ApplicationRunner {

	@Autowired
	private IncidentRepository incidentRepository;

	
	public void run(ApplicationArguments args)  {
		//Qty of records to add
		Long max = 200l;
		
//		Faker faker = new Faker(Locale.SIMPLIFIED_CHINESE);
//
//		for (long i = incidentRepository.count(); i<max; i++) {
//			Incident incident = new Incident();
//			incident.setTitle(faker.name().fullName());
//			incidentRepository.save(incident);
//		}

		//十进制格式与faker内部完全相同
		//需要将字符串解析为BigDecimal
		//需要这样做，因为faker会忽略定义的语言环境，
		//因此可能导致由小数分隔符"，"引起的解析错误
		// Java Faker项目#433的已知问题
//		DecimalFormat formatter = new DecimalFormat("#0.00");
//		formatter.setParseBigDecimal(true);
//
//		for (long i = produtoRepository.count(); i<max; i++) {
//			Produto produto = new Produto();
//			produto.setDescricao(faker.commerce().productName());
//
//			BigDecimal price = (BigDecimal) formatter.parse(faker.commerce().price());
//			produto.setValor(price);
//			produto.setAtivo(faker.bool().bool());
//			produtoRepository.save(produto);
//		}
    }
}
