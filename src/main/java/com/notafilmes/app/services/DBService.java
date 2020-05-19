package com.notafilmes.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notafilmes.app.domain.Filme;

import com.notafilmes.app.repositories.FilmeRepository;

@Service
public class DBService {

	private final FilmeRepository _filmeRepository;

	@Autowired
	DBService(FilmeRepository filmeRepository) {
		_filmeRepository = filmeRepository;
	}

	public void initSeedDB() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Filme filme1 = new Filme(null, "DOLITTLE",
				"Em Dolittle, o Dr. Dolittle (Robert Downey Jr) vive com uma variedade de animais exóticos e conversa com eles diariamente. Quando a jovem rainha Victoria (Jessie Buckley) fica doente, o excêntrico médico e seus amigos peludos embarcam em uma aventura épica em uma ilha mítica para encontrar a cura.",
				sdf.parse("17/01/2020"), "Stephen Gaghan", "Robert Downey Jr;Antonio Banderas;Michael Sheen");

		Filme filme2 = new Filme(null, "RESGATE",
				"Em Resgate, Tyler Rake (Chris Hemsworth) um agente especial recebe a difícil missão de libertar um garoto indiano que é mantido refém na cidade de Dhaka. Apesar de estar preparado fisicamente, ele precisa lidar com crises de identidade e com seu emocional fragilizado por problemas do passado para que consiga designar sua tarefa da melhor maneira possível.",
				sdf.parse("24/04/2020"), "Sam Hargrave", "Chris Hemsworth; Golshifteh Farahani; Rudhraksh Jaiswal");

		Filme filme3 = new Filme(null, "MARIA E JOÃO: O CONTO DAS BRUXAS",
				"Em Maria e João: O Conto das Bruxas, há muito tempo, em um campo distante, Maria (Sophia Lillis) leva seu irmãozinho João (Sammy Leakey) a um bosque escuro, em uma busca desesperada por comida e trabalho. Quando eles encontram Holda (Alice Krige), uma misteriosa mulher que reside na floresta, os dois irmãos descobrem que nem todo conto de fadas termina bem.",
				sdf.parse("20/02/2020"), "Oz Perkins", "Sophia Lillis; Samuel Leakey; Alice Krige");

		Filme filme4 = new Filme(null, "MILAGRE NA CELA 7",
				"Separado de sua filha por ser acusado de um crime que não cometeu, um homem com deficiência intelectual precisa provar sua inocência ao ser preso pela morte da filha de um comandante. Ele passa a contar com a ajuda de seus companheiros de cela e de quem também está do outro lado das grades.",
				sdf.parse("11/10/2019"), "Nuel C. Naval", "Aga Muhlach; Bela Padilla; Xia Vigor");

		Filme filme5 = new Filme(null, "AMEAÇA PROFUNDA",
				"Um grupo de pesquisadores se encontra num laboratório subaquático a onze mil metros de profundidade, quando um terremoto causa a destruição do veículo e expõe a equipe ao risco de morte. Eles são obrigados a caminhar nas profundezas marítimas, com quantidade insuficiente de oxigênio, para tentarem sobreviver. No entanto, conforme se deslocam pelo fundo do mar, descobrem a presença de uma criatura mortal de origem desconhecida.",
				sdf.parse("09/01/2019"), "William Eubank", "Kristen Stewart; Vincent Cassel; T.J. Miller");

				_filmeRepository.saveAll(
				Arrays.asList(filme1, filme2, filme3, filme4, filme5));
	}
}