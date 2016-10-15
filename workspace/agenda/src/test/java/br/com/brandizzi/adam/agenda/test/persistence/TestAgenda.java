package br.com.brandizzi.adam.agenda.test.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.brandizzi.adam.agenda.model.Evento;
import br.com.brandizzi.adam.agenda.persistence.EntityManagerContext;

public class TestAgenda {

	@Test
	public void testCriarEvento() throws Exception {
		try (EntityManagerContext contexto = new EntityManagerContext()) {
			EntityManager entityManager = contexto.getEntityManager();

			entityManager.getTransaction().begin();

			Evento evento = new Evento(1, "Evento-teste", true);

			entityManager.persist(evento);

			entityManager.getTransaction().commit();
		}

		try (EntityManagerContext contexto = new EntityManagerContext()) {
			EntityManager entityManager = contexto.getEntityManager();

			Evento evento = entityManager.find(Evento.class, 1L);

			assertEquals("Evento-teste", evento.getTitulo());
			assertTrue(evento.isAllDay());
		}
	}

}
