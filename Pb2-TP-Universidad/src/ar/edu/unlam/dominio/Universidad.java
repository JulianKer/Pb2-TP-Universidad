package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private ArrayList<Materia> materias;
	private ArrayList<Aula> aulas;
	private ArrayList<Comision> comisiones;
	private ArrayList<InscripcionAlumnoComision> inscripcionesAlumnoComison;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.inscripcionesAlumnoComison = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean registrarAlumno(Alumno nuevoAlumno) {
		Boolean seRegistro = false;
		Alumno encontrado = buscarAlumnoPorDni(nuevoAlumno.getDni());

		if (encontrado == null) {
			this.alumnos.add(nuevoAlumno);
			seRegistro = this.alumnos.contains(nuevoAlumno);
		}
		return seRegistro;
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {
		Alumno encontrado = null;

		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				encontrado = this.alumnos.get(i);
			}
		}
		// para buscar un alumno en especifico podria usar el .contains(alumno) pero
		// como necesito buscarlo x dni, necesito hacer el for igual q antes
		return encontrado;
	}

	public Boolean registraMateria(Materia nuevaMateria) {
		Boolean seRegistro = false;
		Materia encontrada = buscarMateriaPorCodigo(nuevaMateria.getCodigo());

		if (encontrada == null) {
			this.materias.add(nuevaMateria);
			seRegistro = this.materias.contains(nuevaMateria);
		}
		return seRegistro;
	}

	public Materia buscarMateriaPorCodigo(Integer codigo) {
		Materia encontrada = null;

		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo)) {
				encontrada = this.materias.get(i);
			}
		}
		return encontrada;
	}

	public Boolean registrarComision(Comision nuevaComision) {
		Boolean seRegistro = false;
		Comision encontradaPorId = buscarComisionPorIdComision(nuevaComision.getIdComision());
		Comision encontradaPorTurnoYAula = buscarComisionPorTurnoYAula(nuevaComision);

		if (encontradaPorId == null) {
			if (encontradaPorTurnoYAula == null) {
				this.comisiones.add(nuevaComision);
				seRegistro = true;
			}
		}
		return seRegistro;
	}

	public Comision buscarComisionPorTurnoYAula(Comision nuevaComision) {
		Comision encontrada = null;

		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getTurno().equals(nuevaComision.getTurno()) && this.comisiones.get(i).getAula()
					.getNumeroAula().equals(nuevaComision.getAula().getNumeroAula())) {
				encontrada = this.comisiones.get(i);
			}
		}
		return encontrada;
	}

	public Comision buscarComisionPorIdComision(Integer idComision) {
		Comision encontrada = null;

		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getIdComision().equals(idComision)) {
				encontrada = this.comisiones.get(i);
			}
		}
		return encontrada;
	}

	public Boolean registrarProfesor(Profesor nuevoProfe) {
		Boolean seRegistro = false;
		Profesor encontrado = buscarProfesorPorDni(nuevoProfe.getDni());

		if (encontrado == null) {
			this.profesores.add(nuevoProfe);
			seRegistro = true;
		}
		return seRegistro;
	}

	public Profesor buscarProfesorPorDni(Integer dni) {
		Profesor encontrado = null;

		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				encontrado = this.profesores.get(i);
			}
		}
		return encontrado;
	}

	public Boolean agregarCorrelativaAUnaMateria(Integer codigo, Integer codigoAAgregar) {
		Boolean seAgrego = false;
		Materia materia = null;
		Materia materiaAAgregar = null;

		if (!codigo.equals(codigoAAgregar)) {
			materia = buscarMateriaPorCodigo(codigo);
			materiaAAgregar = buscarMateriaPorCodigo(codigoAAgregar);

			if (materia != null && materiaAAgregar != null) {
				seAgrego = materia.agregarCorrelativa(codigoAAgregar);
			}
		}

		return seAgrego;
	}

	public Boolean eliminarCorrelativaDeUnaMateria(Integer codigo, Integer codigoAEliminar) {
		Boolean seElimino = false;
		Materia materia = buscarMateriaPorCodigo(codigo);
		Materia materiaAEliminar = buscarMateriaPorCodigo(codigoAEliminar);

		if (materia != null && materiaAEliminar != null) {
			seElimino = materia.eliminarCorrelativa(codigoAEliminar);
		}
		return seElimino;
	}

	public Boolean registrarAula(Aula nuevaAula) {
		Boolean seRegistro = false;
		Aula encontrada = buscarAulaPorNumero(nuevaAula.getNumeroAula());

		if (encontrada == null) {
			this.aulas.add(nuevaAula);
			seRegistro = true;
		}
		return seRegistro;
	}

	public Aula buscarAulaPorNumero(Integer numeroAula) {
		Aula encontrada = null;

		for (int i = 0; i < this.aulas.size(); i++) {
			if (this.aulas.get(i).getNumeroAula().equals(numeroAula)) {
				encontrada = this.aulas.get(i);
			}
		}
		return encontrada;
	}

	public Boolean inscribirAlumnoAComision(Integer dni, Integer idComision, LocalDate fechaQueSeInscribe) {
		Boolean seInsrcibio = false;
		InscripcionAlumnoComision nuevaInsAlumnoComision = buscarInscripcionPorDniAlumnoYIdComision(dni, idComision);
		Alumno alumAInscribir = buscarAlumnoPorDni(dni);
		Comision comAInscibir = buscarComisionPorIdComision(idComision);

		if (alumAInscribir != null && comAInscibir != null && nuevaInsAlumnoComision == null) { 
																								
			if (saberSiElAlumnoTieneLasCorrelativasDeUnaMateriaConPorLoMenosMasDe4(alumAInscribir,
					comAInscibir.getMateria())) { //         ---->  verifico si tiene las correlativas con + de 4
				
				if (!fechaQueSeInscribe.isBefore(comAInscibir.getCiclo().getFechaInicioInscripcion()) // ----> verifico que se
						&& !fechaQueSeInscribe.isAfter(comAInscibir.getCiclo().getFechaFinInscripcion())) { // encuentre dentro de
					                                                                                        // la fecha
					if (comAInscibir.saberSiHayEspacioEnElAula()) { // -----------> verifico si hay espacio en el aula
						nuevaInsAlumnoComision = new InscripcionAlumnoComision(alumAInscribir, comAInscibir);
						seInsrcibio = this.inscripcionesAlumnoComison.add(nuevaInsAlumnoComision);
					}
				}
			}
		}
		return seInsrcibio;
	}

	public Boolean saberSiElAlumnoTieneLasCorrelativasDeUnaMateriaConPorLoMenosMasDe4(Alumno alumno, Materia materia) { // con
																														// "cursadas"
		Boolean tieneCursadasLasCorrelativas = false;                             // se refiere a q si almenos las tiene con mas de 4
		Comision comisionDeCorrelativaEncontrada = null;
		InscripcionAlumnoComision inscripcionDeCorrelativaEncontrada = null;
		Integer cantAprobadas = 0;

		for (int i = 0; i < materia.getCorrelativas().size(); i++) {
			comisionDeCorrelativaEncontrada = buscarComisionPorCodigoMateria(materia.getCorrelativas().get(i));

			if (comisionDeCorrelativaEncontrada != null) {
				inscripcionDeCorrelativaEncontrada = buscarInscripcionPorDniAlumnoYIdComision(alumno.getDni(),
						comisionDeCorrelativaEncontrada.getIdComision());
				if (inscripcionDeCorrelativaEncontrada != null
						&& inscripcionDeCorrelativaEncontrada.calcularNotaFinal() >= 4) {
					cantAprobadas++;
				}
			}
		}

		if (cantAprobadas.equals(materia.getCorrelativas().size())) {
			tieneCursadasLasCorrelativas = true;
		}
		return tieneCursadasLasCorrelativas;
	}

	public Comision buscarComisionPorCodigoMateria(Integer codigo) {
		Comision encontrada = null;

		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getMateria().getCodigo().equals(codigo)) {
				encontrada = this.comisiones.get(i);
			}
		}
		return encontrada;
	}

	public InscripcionAlumnoComision buscarInscripcionPorDniAlumnoYIdComision(Integer dni, Integer idComision) {
		InscripcionAlumnoComision encontrada = null;

		for (int i = 0; i < this.inscripcionesAlumnoComison.size(); i++) {
			if (this.inscripcionesAlumnoComison.get(i).getAlumno().getDni().equals(dni)
					&& this.inscripcionesAlumnoComison.get(i).getComision().getIdComision().equals(idComision)) {
				encontrada = this.inscripcionesAlumnoComison.get(i);
			}
		}
		return encontrada;
	}

	public Boolean evaluar(Integer dni, Integer codigoMateria, TipoDeNota tipoDeNota, Integer valorNota) {
		Boolean seEvaluo = false;

		Alumno alumnoEncontrado = buscarAlumnoPorDni(dni);
		Materia materiaEncontrada = buscarMateriaPorCodigo(codigoMateria);
		Comision comisionEncontradaPorLaMateria;
		InscripcionAlumnoComision inscripcionEncontradaPorAlumnoYComision;

		if (alumnoEncontrado != null && materiaEncontrada != null) {
			comisionEncontradaPorLaMateria = buscarComisionPorCodigoMateria(codigoMateria);

			if (comisionEncontradaPorLaMateria != null) {
				inscripcionEncontradaPorAlumnoYComision = buscarInscripcionPorDniAlumnoYIdComision(dni,
						comisionEncontradaPorLaMateria.getIdComision());

				if (inscripcionEncontradaPorAlumnoYComision != null
						&& saberSiElAlumnoTieneLasCorrelativasDeUnaMateriaConMasDe7(dni, materiaEncontrada)) {
					seEvaluo = inscripcionEncontradaPorAlumnoYComision.calificar(tipoDeNota, valorNota);
				}
			}
		}
		return seEvaluo;
	}

	public Boolean saberSiElAlumnoTieneLasCorrelativasDeUnaMateriaConMasDe7(Integer dni, Materia materia) {
		Boolean lasTieneConMasDe7 = false;
		Integer cantMateriasConMasDe7 = 0;
		Comision comisionDeLaCorrelativaEncontrada = null;
		InscripcionAlumnoComision insAlumComEncontrada = null;
		Integer notaFinal = 0;

		for (int i = 0; i < materia.getCorrelativas().size(); i++) {
			comisionDeLaCorrelativaEncontrada = buscarComisionPorCodigoMateria(materia.getCodigo());

			if (comisionDeLaCorrelativaEncontrada != null) {
				insAlumComEncontrada = buscarInscripcionPorDniAlumnoYIdComision(dni,
						comisionDeLaCorrelativaEncontrada.getIdComision());

				if (insAlumComEncontrada != null) {
					notaFinal = insAlumComEncontrada.calcularNotaFinal();

					if (notaFinal >= 7) {
						cantMateriasConMasDe7++;
					}
				}
			}
		}

		if (cantMateriasConMasDe7.equals(materia.getCorrelativas().size())) {
			lasTieneConMasDe7 = true;
		}
		return lasTieneConMasDe7;
	}
}
