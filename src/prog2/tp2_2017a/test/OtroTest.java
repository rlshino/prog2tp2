package prog2.tp2_2017a.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import prog2.tp2_2017a.Palabras;
import prog2.tp2_2017a.TrieChar;

@RunWith(Enclosed.class)
public class OtroTest {
	/**
	 * Tests basicos de ADN
	 */
	public static class TestBasicoADN {
		private List<String> busq;
		private TrieChar<String> personas;
		private TrieChar<String> personas2;
		
		public TestBasicoADN(){
			personas = new TrieChar<String>(new Palabras());
			personas2 = new TrieChar<String>(new Palabras());
		}

		@Test
		public void ejemploConsigna() {
			TrieChar<String> personas3 = new TrieChar<String>(new Palabras());
			TrieChar<String> personas4 = null;
			assertFalse(personas3.equals(personas4));
			personas.agregar("psicotecnico", "Gino");
			personas.agregar("psicologo", "Pablo");
			personas.agregar("psicofisico", "Fabian");
			personas.agregar("psicologico", "Martina");
			personas.agregar("psycho", "Rosalinda");
			personas.agregar("psicologo", "Fabiana");

			assertEquals("Fabiana", personas.obtener("psicologo"));

			busq = personas.busqueda("psico");
			assertEquals(4, busq.size());
			assertTrue(busq.contains("Gino"));
			assertTrue(busq.contains("Fabiana"));
			
			personas.eliminar("psicol");
			busq = personas.busqueda("psico");
			assertEquals(2, busq.size());

			personas2.agregar("psicotecnico", "Gino");
			personas2.agregar("psicofisico", "Fabian");
			personas2.agregar("psycho", "Rosalinda");
			
			assertTrue(personas.equals(personas2));
		}
	}
}
