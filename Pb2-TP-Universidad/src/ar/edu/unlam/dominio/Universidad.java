package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private ArrayList<Materia> materias;
	private ArrayList<CicloLectivo> ciclos;
	private ArrayList<Aula> aulas;
	private ArrayList<Comision> comisiones;
	private ArrayList<InscripcionAlumnoComision> inscripcionesAlumnoComison;
	private ArrayList<InscripcionProfesorComision> inscripcionesProfeComision;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.materias = new ArrayList<>();		
		this.ciclos = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.inscripcionesAlumnoComison = new ArrayList<>();
		this.inscripcionesProfeComision = new ArrayList<>();
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

		if (encontrada == null) { // -------------------->>>>>>> ACA AGREGAR LA LIMITACION
			this.materias.add(nuevaMateria);                // DE MATERIAS: && this.materias.size() < 20
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
		Comision encontradaPorMateriaCicloYTurno = buscarComisionPorMateriaCicloYTurno(nuevaComision);

		if (encontradaPorMateriaCicloYTurno == null) {
			this.comisiones.add(nuevaComision);
			seRegistro = true;
		}
		
		return seRegistro;
	}

	public Comision buscarComisionPorMateriaCicloYTurno(Comision nuevaComision) {
		Comision encontrada = null;

		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getMateria().getCodigo().equals(nuevaComision.getMateria().getCodigo())
					&& this.comisiones.get(i).getTurno().equals(nuevaComision.getTurno())
					&& this.comisiones.get(i).getCiclo().getFechaInicioCiclo().equals(nuevaComision.getCiclo().getFechaInicioCiclo())
					&& this.comisiones.get(i).getCiclo().getFechaFinCiclo().equals(nuevaComision.getCiclo().getFechaFinCiclo())
					&& this.comisiones.get(i).getCiclo().getFechaInicioInscripcion().equals(nuevaComision.getCiclo().getFechaInicioInscripcion())
					&& this.comisiones.get(i).getCiclo().getFechaFinInscripcion().equals(nuevaComision.getCiclo().getFechaFinInscripcion())){
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
		Alumno alumAInscribir = buscarAlumnoPorDni(dni);
		
		// como pueden haber varias comisiones de mismo codigo, busco la q tenga ese codigo 
        // y ademas que tenga esa fecha de inscripcion, asi se especificamente cual comision es
		Comision comAInscibir = buscarComisionPorIdYFechQueSeInscribe(idComision, fechaQueSeInscribe); 
		InscripcionAlumnoComision nuevaInsAlumnoComision = null;
		
		if (comAInscibir != null) { 
			nuevaInsAlumnoComision = buscarInscripcionPorDniAlumnoYMateria(dni, comAInscibir.getMateria());
		}
		
		if (alumAInscribir == null || comAInscibir == null) 
			return false;

		if (nuevaInsAlumnoComision != null && nuevaInsAlumnoComision.calcularNotaFinal() >= 4) 
			return false;

		if (!saberSiElAlumnoTieneLasCorrelativasDeUnaMateriaConPorLoMenosMasDe4(alumAInscribir,comAInscibir.getMateria())) 
			return false;
		
		if (fechaQueSeInscribe.isBefore(comAInscibir.getCiclo().getFechaInicioInscripcion()) && !fechaQueSeInscribe.isAfter(comAInscibir.getCiclo().getFechaFinInscripcion())) 
			return false;
		
		if (!saberSiHayEspacioEnElAula(comAInscibir.getAula())) 
			return false;
		
		if (saberSiEstaInscriptoEnOtraComisionEnElMismoTurnoDiaYCiclo(alumAInscribir, comAInscibir)) 
			return false;
		
		nuevaInsAlumnoComision = new InscripcionAlumnoComision(alumAInscribir, comAInscibir);
		seInsrcibio = this.inscripcionesAlumnoComison.add(nuevaInsAlumnoComision);
		
		return seInsrcibio;
	}

	public Boolean saberSiHayEspacioEnElAula(Aula aula) {
		Boolean hayEspacio = false;
		Integer cantAlumnos = 0;
		
		for (int i = 0; i < this.inscripcionesAlumnoComison.size(); i++) {
			if (this.inscripcionesAlumnoComison.get(i).getComision().getAula().getNumeroAula().equals(aula.getNumeroAula())) {
				cantAlumnos++;
			}
		}
		
		if (cantAlumnos < aula.getCantMaxDeAlumnos()) {
			hayEspacio = true;
		}
		return hayEspacio;
	}

	public InscripcionAlumnoComision buscarInscripcionPorDniAlumnoYMateria(Integer dni, Materia materia) {
		InscripcionAlumnoComision encontrada = null;
		
		for (int i = 0; i < this.inscripcionesAlumnoComison.size(); i++) {
			if (this.inscripcionesAlumnoComison.get(i).getAlumno().getDni().equals(dni) 
					&& this.inscripcionesAlumnoComison.get(i).getComision().getMateria().getCodigo().equals(materia.getCodigo())) {
				encontrada = this.inscripcionesAlumnoComison.get(i);
			}
		}
		return encontrada;
	}

	public Comision buscarComisionPorIdYFechQueSeInscribe(Integer idComision, LocalDate fechaQueSeInscribe) {
		Comision encontrada = null;
		
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getIdComision().equals(idComision) 
					&& fechaQueSeInscribe.isAfter(this.comisiones.get(i).getCiclo().getFechaInicioInscripcion())
					&& fechaQueSeInscribe.isBefore(this.comisiones.get(i).getCiclo().getFechaFinInscripcion())) {
				encontrada = this.comisiones.get(i);
			}
		}
		
		return encontrada;
	}

	public Boolean saberSiEstaInscriptoEnOtraComisionEnElMismoTurnoDiaYCiclo(Alumno alumAInscribir,
			Comision comAInscibir) {
		
		Boolean estaEnOtra = false;
		
		for (int i = 0; i < this.inscripcionesAlumnoComison.size(); i++) {
			if (this.inscripcionesAlumnoComison.get(i).getAlumno().getDni().equals(alumAInscribir.getDni())
					&& this.inscripcionesAlumnoComison.get(i).getComision().getTurno().equals(comAInscibir.getTurno())
					&& this.inscripcionesAlumnoComison.get(i).getComision().getDias().equals(comAInscibir.getDias())
					&& this.inscripcionesAlumnoComison.get(i).getComision().getCiclo().getFechaInicioCiclo().equals(comAInscibir.getCiclo().getFechaInicioCiclo())
					&& this.inscripcionesAlumnoComison.get(i).getComision().getCiclo().getFechaFinCiclo().equals(comAInscibir.getCiclo().getFechaFinCiclo())) {
				estaEnOtra = true;
			}
		}
		return estaEnOtra;
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
		
		if (alumnoEncontrado == null || materiaEncontrada == null)
			return false;
		
		comisionEncontradaPorLaMateria = buscarComisionPorCodigoMateria(codigoMateria);
				
		if (comisionEncontradaPorLaMateria == null) 
			return false;
		
		inscripcionEncontradaPorAlumnoYComision = buscarInscripcionPorDniAlumnoYIdComision(dni, comisionEncontradaPorLaMateria.getIdComision());
		
		if (inscripcionEncontradaPorAlumnoYComision == null) 
			return false;
		
		if (valorNota >= 7) {
			if (saberSiElAlumnoTieneLasCorrelativasDeUnaMateriaConMasDe7(dni, materiaEncontrada)) {
				seEvaluo = inscripcionEncontradaPorAlumnoYComision.calificar(tipoDeNota, valorNota);							
			}
		}else {
			seEvaluo = inscripcionEncontradaPorAlumnoYComision.calificar(tipoDeNota, valorNota);
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
			comisionDeLaCorrelativaEncontrada = buscarComisionPorCodigoMateria(materia.getCorrelativas().get(i));

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

	public Boolean registrarCicloLectivo(CicloLectivo nuevoCiclo) {
		Boolean seRegistro = false;
		CicloLectivo encontradoPorId = buscarCicloPorId(nuevoCiclo);
		CicloLectivo encontradoPorFechasSuperpuestas = busacrCicloPorFechasSuperpuestas(nuevoCiclo);
		
		if (encontradoPorId == null) {
			if (encontradoPorFechasSuperpuestas == null) {
				seRegistro = this.ciclos.add(nuevoCiclo);				
			}
		}
		return seRegistro;
	}

	public CicloLectivo busacrCicloPorFechasSuperpuestas(CicloLectivo nuevoCiclo) {
		CicloLectivo encontrado = null;
		
		for (int i = 0; i < this.ciclos.size(); i++) {
			if (nuevoCiclo.getFechaInicioCiclo().isAfter(this.ciclos.get(i).getFechaInicioCiclo()) 
					&& nuevoCiclo.getFechaInicioCiclo().isBefore(this.ciclos.get(i).getFechaFinCiclo())
					|| nuevoCiclo.getFechaFinCiclo().isAfter(this.ciclos.get(i).getFechaInicioCiclo()) 
					&& nuevoCiclo.getFechaFinCiclo().isBefore(this.ciclos.get(i).getFechaFinCiclo())) {
				encontrado = this.ciclos.get(i);
			}
		}
		return encontrado;
	}

	public CicloLectivo buscarCicloPorId(CicloLectivo nuevoCiclo) {
		CicloLectivo encontrado = null;
		
		for (int i = 0; i < this.ciclos.size(); i++) {
			if (this.ciclos.get(i).getIdDelCiclo().equals(nuevoCiclo.getIdDelCiclo())) {
				encontrado = this.ciclos.get(i);
			}
		}
		return encontrado;
	}
	
	public Boolean asignarProfesorComision(Integer dni, Integer codigoComision) {
	
		Profesor profeEncontrado = buscarProfesorPorDni(dni);
		Comision comisionEncontrada = buscarComisionPorIdComision(codigoComision);
		
		if (profeEncontrado == null || comisionEncontrada == null) {
			return false;			
		}
		
		if (saberSiElPorfeYaEsDocenteEnEstaComision(dni, codigoComision)) {
			return false;			
		} 
		
		if (saberSiElProfeEstaEnOtraComisionDeMismoCicloTurnoYDias(dni, comisionEncontrada)) {
			return false;			
		}
		
		if (saberCuantosProfesHayEnLaComision(codigoComision) >= saberCantidadDeProfesNecesariosParaUnaComision(codigoComision)) {
			return false;			
		}
		
		InscripcionProfesorComision insProfeComision = new InscripcionProfesorComision(profeEncontrado, comisionEncontrada);
		
		return this.inscripcionesProfeComision.add(insProfeComision);
	}

	private Boolean saberSiElProfeEstaEnOtraComisionDeMismoCicloTurnoYDias(Integer dni, Comision comisionEncontrada) {
		Boolean estaEnOtra = false;
		
		for (int i = 0; i < this.inscripcionesProfeComision.size(); i++) {
			if (this.inscripcionesProfeComision.get(i).getProfesor().getDni().equals(dni) 
					&& this.inscripcionesProfeComision.get(i).getComision().getCiclo().getFechaInicioCiclo().equals(comisionEncontrada.getCiclo().getFechaInicioCiclo())
					&& this.inscripcionesProfeComision.get(i).getComision().getCiclo().getFechaFinCiclo().equals(comisionEncontrada.getCiclo().getFechaFinCiclo())
					&& this.inscripcionesProfeComision.get(i).getComision().getTurno().equals(comisionEncontrada.getTurno()) 
					&& this.inscripcionesProfeComision.get(i).getComision().getDias().equals(comisionEncontrada.getDias())) {
				estaEnOtra = true;
			}
		}
		
		return estaEnOtra;
	}

	private Integer saberCantidadDeProfesNecesariosParaUnaComision(Integer codigoComision) {
		Integer profesNecesarios = 0;
		Integer cantAlumnos = 0;
		
		for (int i = 0; i < this.inscripcionesAlumnoComison.size(); i++) {
			if (this.inscripcionesAlumnoComison.get(i).getComision().getIdComision().equals(codigoComision) // coincide la comision
					&& this.inscripcionesAlumnoComison.get(i).calcularNotaFinal().equals(0)) {// esa inscripcion no debe tener nota final
				cantAlumnos++;      // pq sino, estaria contando un alumno de una inscripcion de mismo codigo pero q ya fue aprobado, entonces no cuenta
			}
		}
		                                  // 1 profe cada 20
		profesNecesarios = (int) Math.ceil(cantAlumnos/20.0); // ceil redondea, ej: cantAlumnos es de 21, entonces: 21/20 = 1.05--> redondea a 2
		return profesNecesarios;                     // osea que necesito 2 profesores 
	}

	private Integer saberCuantosProfesHayEnLaComision(Integer codigoComision) {
		Integer cantProfesEnLaComsion = 0;
		
		for (int i = 0; i < inscripcionesProfeComision.size(); i++) {
			if (this.inscripcionesProfeComision.get(i).getComision().getIdComision().equals(codigoComision)) {
				cantProfesEnLaComsion++;
			}
		}
		return cantProfesEnLaComsion;
	}

	private Boolean saberSiElPorfeYaEsDocenteEnEstaComision(Integer dni, Integer codigoComision) {
		Boolean yaEsDocenteEnOtra = false;
		
		for (int i = 0; i < this.inscripcionesProfeComision.size(); i++) {
			if (this.inscripcionesProfeComision.get(i).getComision().getIdComision().equals(codigoComision)
					&& this.inscripcionesProfeComision.get(i).getProfesor().getDni().equals(dni)) {
				yaEsDocenteEnOtra = true;
			}
		}
		return yaEsDocenteEnOtra;
	}
	
	public Double obtenerPromedio(Integer dni) {
		Double promedio = 0.0;
		Double sumatoria = 0.0;
		Double cantNotas = 0.0;
		
		for (InscripcionAlumnoComision inscriAlumCom: this.inscripcionesAlumnoComison) {
			if (inscriAlumCom.getAlumno().getDni().equals(dni) && inscriAlumCom.calcularNotaFinal() >= 4) {
				sumatoria += inscriAlumCom.calcularNotaFinal();
				cantNotas++;				
			}
		}
		
		promedio = sumatoria/cantNotas;
		return promedio;
	}
	
	public ArrayList<InscripcionAlumnoComision> obtenerListadoDeMateriasAprobadas(Integer dni) {
		Alumno encontrado = buscarAlumnoPorDni(dni);
		
		if (encontrado == null) { // --> directamente si el alumno no existe
			return null;    // te retorno null pq no va a encontrar nada
		}
		
		ArrayList <InscripcionAlumnoComision> listaAprobadas = new ArrayList<>();
		
		for (int i = 0; i < this.inscripcionesAlumnoComison.size(); i++) {
			if (this.inscripcionesAlumnoComison.get(i).getAlumno().getDni().equals(dni)
					&& this.inscripcionesAlumnoComison.get(i).calcularNotaFinal() >= 7) {
				listaAprobadas.add(this.inscripcionesAlumnoComison.get(i));
			}
		}
		
		return listaAprobadas;
	}

	public ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoPorDni(dniAlumno);
		
		if (encontrado == null) { // --> directamente si el alumno no existe
			return null;    // te retorno null pq no va a encontrar nada
		}
		
		ArrayList <Materia> materiasQueFaltanCursar = new ArrayList<>();
		ArrayList <Materia> listaAprobadas = new ArrayList<>();
		
		materiasQueFaltanCursar.addAll(this.materias); // duplico el array de materias para
		// que al eliminarlas, y hacer el calculo de cuantas le faltan cursar, no modifique el array original
		
		// ahora recorro las inscripciones y la q coincida con el dni alumno, si su nota final
		// es de 7 para arriba, agrego la materia de esa inscripcion a mi array de materias aprobadas
		for (int i = 0; i < this.inscripcionesAlumnoComison.size(); i++) {
			if (this.inscripcionesAlumnoComison.get(i).getAlumno().getDni().equals(dniAlumno)
					&& this.inscripcionesAlumnoComison.get(i).calcularNotaFinal() >= 7) {
				listaAprobadas.add(this.inscripcionesAlumnoComison.get(i).getComision().getMateria());
			}
		}
		
		// a las materias totales, le elimino las que ya estan aprobadas y lo devuelvo
		materiasQueFaltanCursar.removeAll(listaAprobadas);
		
		return materiasQueFaltanCursar;
	}
	
	public void crearYRegistrarMateriasDeDesarrolloWeb() {
		
		// creacion de TODAS las materias de Desarrollo Web
		
		String nombre1 = "Programacion Basica 1";
		Integer codigo1 = 2619;
		Materia nueva1 = new Materia(codigo1, nombre1);
		this.registraMateria(nueva1);
		
		String nombre2 = "Informatica General";
		Integer codigo2 = 2620;
		Materia nueva2 = new Materia(codigo2, nombre2);
		this.registraMateria(nueva2);
		
		String nombre3 = "Matematica General";
		Integer codigo3 = 2621;
		Materia nueva3 = new Materia(codigo3, nombre3);
		this.registraMateria(nueva3);
		
		String nombre4 = "Ingles Tec 1";
		Integer codigo4 = 2622;
		Materia nueva4 = new Materia(codigo4, nombre4);
		this.registraMateria(nueva4);
		
		String nombre5 = "Programacion Basica 2";
		Integer codigo5 = 2623;
		Materia nueva5 = new Materia(codigo5, nombre5);
		this.agregarCorrelativaAUnaMateria(codigo5, codigo1);
		this.registraMateria(nueva5);
		
		String nombre6 = "Programacion Web 1";
		Integer codigo6 = 2624;
		Materia nueva6 = new Materia(codigo6, nombre6);
		this.agregarCorrelativaAUnaMateria(codigo6, codigo1);
		this.agregarCorrelativaAUnaMateria(codigo6, codigo2);
		this.registraMateria(nueva6);
		
		String nombre7 = "Base De Datos 1";
		Integer codigo7 = 2625;
		Materia nueva7 = new Materia(codigo7, nombre7);
		this.agregarCorrelativaAUnaMateria(codigo7, codigo1);
		this.agregarCorrelativaAUnaMateria(codigo7, codigo2);
		this.agregarCorrelativaAUnaMateria(codigo7, codigo3);
		this.registraMateria(nueva7);
		
		String nombre8 = "Introduccion al disenio grafico";
		Integer codigo8 = 2626;
		Materia nueva8 = new Materia(codigo8, nombre8);
		this.agregarCorrelativaAUnaMateria(codigo8, codigo2);
		this.registraMateria(nueva8);
		
		String nombre9 = "Ingles tecnico 2";
		Integer codigo9 = 2627;
		Materia nueva9 = new Materia(codigo9, nombre9);
		this.agregarCorrelativaAUnaMateria(codigo9, codigo4);
		this.registraMateria(nueva9);
		
		String nombre10 = "Programacion Web 2";
		Integer codigo10 = 2628;
		Materia nueva10 = new Materia(codigo10, nombre10);
		this.agregarCorrelativaAUnaMateria(codigo10, codigo5);
		this.agregarCorrelativaAUnaMateria(codigo10, codigo6);
		this.agregarCorrelativaAUnaMateria(codigo10, codigo7);
		this.registraMateria(nueva10);
		
		String nombre11 = "Disenio de aplicaciones Web";
		Integer codigo11 = 2629;
		Materia nueva11 = new Materia(codigo11, nombre11);
		this.agregarCorrelativaAUnaMateria(codigo11, codigo5);
		this.agregarCorrelativaAUnaMateria(codigo11, codigo6);
		this.agregarCorrelativaAUnaMateria(codigo11, codigo7);
		this.registraMateria(nueva11);
		
		String nombre12 = "Visualizacion e interfaces";
		Integer codigo12 = 2630;
		Materia nueva12 = new Materia(codigo12, nombre12);
		this.agregarCorrelativaAUnaMateria(codigo12, codigo6);
		this.agregarCorrelativaAUnaMateria(codigo12, codigo8);
		this.registraMateria(nueva12);
		
		String nombre13 = "Taller web 1";
		Integer codigo13 = 2631;
		Materia nueva13 = new Materia(codigo13, nombre13);
		this.agregarCorrelativaAUnaMateria(codigo13, codigo5);
		this.agregarCorrelativaAUnaMateria(codigo13, codigo6);
		this.agregarCorrelativaAUnaMateria(codigo13, codigo7);
		this.registraMateria(nueva13);
		
		String nombre14 = "Base de datos 2";
		Integer codigo14 = 2632;
		Materia nueva14 = new Materia(codigo14, nombre14);
		this.agregarCorrelativaAUnaMateria(codigo14, codigo7);
		this.agregarCorrelativaAUnaMateria(codigo14, codigo11);
		this.registraMateria(nueva14);
		
		String nombre15 = "Programacion web 3";
		Integer codigo15 = 2633;
		Materia nueva15 = new Materia(codigo15, nombre15);
		this.agregarCorrelativaAUnaMateria(codigo15, codigo10);
		this.agregarCorrelativaAUnaMateria(codigo15, codigo11);
		this.agregarCorrelativaAUnaMateria(codigo15, codigo12);
		this.registraMateria(nueva15);
		
		String nombre16 = "Tecnologia en redes";
		Integer codigo16 = 2634;
		Materia nueva16 = new Materia(codigo16, nombre16);
		this.agregarCorrelativaAUnaMateria(codigo16, codigo12);
		this.registraMateria(nueva16);
		
		String nombre17 = "Taller web 2";
		Integer codigo17 = 2635;
		Materia nueva17 = new Materia(codigo17, nombre17);
		this.agregarCorrelativaAUnaMateria(codigo17, codigo13);
		this.registraMateria(nueva17);
		
		String nombre18 = "Seguridad y calidad en aplicaciones web";
		Integer codigo18 = 2636;
		Materia nueva18 = new Materia(codigo18, nombre18);
		this.agregarCorrelativaAUnaMateria(codigo18, codigo10);
		this.agregarCorrelativaAUnaMateria(codigo18, codigo11);
		this.registraMateria(nueva18);
		
		String nombre19 = "Introduccion a la administracion de proyectos";
		Integer codigo19 = 2637;
		Materia nueva19 = new Materia(codigo19, nombre19);
		this.agregarCorrelativaAUnaMateria(codigo19, codigo14);
		this.agregarCorrelativaAUnaMateria(codigo19, codigo15);
		this.agregarCorrelativaAUnaMateria(codigo19, codigo16);
		this.registraMateria(nueva19);
		
		String nombre20 = "Taller practico integrador";
		Integer codigo20 = 2638;
		Materia nueva20 = new Materia(codigo20, nombre20);
		this.agregarCorrelativaAUnaMateria(codigo20, codigo14);
		this.agregarCorrelativaAUnaMateria(codigo20, codigo15);
		this.agregarCorrelativaAUnaMateria(codigo20, codigo16);
		this.agregarCorrelativaAUnaMateria(codigo20, codigo17);
		this.agregarCorrelativaAUnaMateria(codigo20, codigo18);
		this.registraMateria(nueva20);
	}
}
