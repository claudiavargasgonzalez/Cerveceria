package com.sierramaestra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Usuarios", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	/*@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn
	@JoinTable(
			name = "usuarios_roles",
					joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
					inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id"))*/
	@Column(name="rol")
	private String rol;
	
	
	
	public Usuario(String nombre, String apellido, String email, String password, String rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}
	public Usuario(Long id, String nombre, String apellido, String email, String password, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}
	public Usuario() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

}
