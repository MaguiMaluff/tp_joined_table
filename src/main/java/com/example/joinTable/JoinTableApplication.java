package com.example.joinTable;

import com.example.joinTable.entidades.Alumno;
import com.example.joinTable.entidades.Profesor;
import com.example.joinTable.enuneraciones.Especialidades;
import com.example.joinTable.enuneraciones.Titulos;
import com.example.joinTable.repositorios.AlumnoRepository;
import com.example.joinTable.repositorios.PersonaRepository;

import com.example.joinTable.repositorios.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class JoinTableApplication {

	private static final Logger logger = LoggerFactory.getLogger(JoinTableApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;
	public static void main(String[] args) {
		SpringApplication.run(JoinTableApplication.class, args);

		System.out.println("funcionando");
	}




	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			Profesor pro1 = Profesor.builder()
					.nombre("Carolina")
					.apellido("López")
					.fechaIngreso(LocalDate.of(2015, 3, 12))
					.cantHijos(2)
					.edad(40)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("3050.75"))
					.build();

			Profesor pro2 = Profesor.builder()
					.nombre("Ricardo")
					.apellido("Martínez")
					.fechaIngreso(LocalDate.of(2010, 7, 21))
					.cantHijos(1)
					.edad(45)
					.titulo(Titulos.LICENCIADO)
					.sueldo(new BigDecimal("1800.50"))
					.build();

			Alumno alu1 = Alumno.builder()
					.nombre("Sofía")
					.apellido("González")
					.edad(19)
					.especialidad(Especialidades.BACHILLER)
					.legajo(12345)
					.build();

			Alumno alu2 = Alumno.builder()
					.nombre("Lucas")
					.apellido("Rodríguez")
					.edad(23)
					.especialidad(Especialidades.BACHILLER)
					.legajo(54321)
					.build();

			Alumno alu3 = Alumno.builder()
					.nombre("Valentina")
					.apellido("Morales")
					.edad(21)
					.especialidad(Especialidades.PERITO_MERCANTIL)
					.legajo(67890)
					.build();

			profesorRepository.save(pro1);
			profesorRepository.save(pro2);
			alumnoRepository.save(alu1);
			alumnoRepository.save(alu2);
			alumnoRepository.save(alu3);












		};

	};




}
