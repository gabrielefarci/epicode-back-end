package com.epicode.project_s3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "progetto_S3";
	String user = "postgres";
	String password = "root";
	Statement st;
	
	private Connection conn;
	
	//metodo connessione al database
	public DbConnection() throws SQLException {
		conn = DriverManager.getConnection(url + dbName, user, password);
		st = conn.createStatement();
		createTableUtenti();
		createTablePresito();
		createTableCatalogoLibri();
		createTableCatalogoRiviste();
	}
	
	//creazione tabella utenti
	public void createTableUtenti() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS utenti ("
				+ "	nome VARCHAR NOT NULL,"
				+ "	cognome VARCHAR NOT NULL,"
				+ "	data_nascita DATE NOT NULL,"
				+ "	numero_tessera SERIAL NOT NULL PRIMARY KEY"
				+ " );";
		st.executeUpdate(sql);
	}
	
	//creazione tabella prestito
	public void createTablePresito() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS prestito ("
				+ "	utente INTEGER NOT NULL,"
				+ "	elemento_prestato VARCHAR NOT NULL,"
				+ "	data_inzio_prestito DATE NOT NULL,"
				+ "	data_restituzione_prevista DATE NOT NULL,"
				+ " data_restituzione_effettiva DATE NOT NULL,"
				+ " CONSTRAINT utente_fk FOREIGN KEY (utente) REFERENCES utenti (numero_tessera)"
				+ " );";
		st.executeUpdate(sql);
	}
	
	//inserimento di un utente nella tabella utenti
	public void inserisciUtente(Utente u) throws SQLException {
		String sql = "INSERT INTO utenti (nome, cognome, data_nascita) VALUES ('"+u.getNome()+"', '"+u.getCognome()+"', '"+u.getData_nascita().toString()+"');";
		st.executeUpdate(sql);
		System.out.println(u.getNome() + " " + u.getCognome() + " created");
	}
	
	//rimozione di un utente dalla tabella utenti
	public void cancellaUtente(int numero_tessera) throws SQLException {
		String sql = "DELETE FROM utenti WHERE numero_tessera = " + numero_tessera;
		st.executeUpdate(sql);
		System.out.println("Utente eliminato");
	}
	
	//inserimento di un elemento nella tabella prestito
	public void inserisciElementoInPrestito(Prestito p) throws SQLException {
		String sql = "INSERT INTO prestito (utente, elemento_prestato, data_inizio_prestito, data_restituzione_prevista, data_restituzione_effettiva) "
				+ "VALUES ('"+p.getUtente()+"', '"+p.getElemento_prestato()+"', '"+p.getData_inizio_prestito()+"', '"+p.getData_restituzione_prevista()+"', '"+p.getData_restituzione_effettiva()+"');";
		st.executeUpdate(sql);
	}
	
	//creazione tabella catalogo_libri
	public void createTableCatalogoLibri() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS catalogo_libri ("
				+ "	codice_ISBN INT UNIQUE NOT NULL PRIMARY KEY,"
				+ "	titolo VARCHAR NOT NULL,"
				+ "	anno_pubblicazione INTEGER NOT NULL,"
				+ "	numero_pagine INTEGER NOT NULL,"
				+ " autore CHAR NOT NULL,"
				+ " genere CHAR NOT NULL"
				+ " );";
		st.executeUpdate(sql);
	}
	
	//creazione tabella catalogo_riviste
	public void createTableCatalogoRiviste() throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS catalogo_riviste ("
				+ "	codice_ISBN INT UNIQUE NOT NULL PRIMARY KEY,"
				+ "	titolo VARCHAR NOT NULL,"
				+ "	anno_pubblicazione INTEGER NOT NULL,"
				+ "	numero_pagine INTEGER NOT NULL"
				+ " );";
		st.executeUpdate(sql);
	}
	
	//inserimento di un libro nella tabella catalogo_libri
	public void inserisciLibro(ElementiCatalogo el, Libri l) throws SQLException {
		String sql = "INSERT INTO catalogo_libri (codice_ISBN, titolo, anno_pubblicazione, numero_pagine, autore, genere) VALUES ('"+el.getIsbn()+"', '"+el.getTitle()+"', '"+el.getPublicationYear()+"', '"+el.getPageCount()+"', '"+l.getAutore()+"', '"+l.getGenere()+"');";
		st.executeUpdate(sql);
		System.out.println("\nIl libro " + el.getTitle() + " è stato inserito nel database.\n");
	}
	
	//inserimento di una rivista nella tabella catalogo_riviste
	public void inserisciRivista(ElementiCatalogo el, Riviste r) throws SQLException {
		String sql = "INSERT INTO catalogo_riviste (codice_ISBN, titolo, anno_pubblicazione, numero_pagine) VALUES ('"+el.getIsbn()+"', '"+el.getTitle()+"', '"+el.getPublicationYear()+"', '"+el.getPageCount()+"');";
		st.executeUpdate(sql);
		System.out.println("\nLa rivista " + el.getTitle() + " è stata inserita nel database.\n");
	}
	
	//rimozione di un elemento dal catalogo
	public void cancellaElemento(int isbn) throws SQLException {
		String sql1 = "DELETE FROM catalogo_libri WHERE codice_ISBN = ?";
	    PreparedStatement pstmt1 = conn.prepareStatement(sql1);
	    pstmt1.setInt(1, isbn);
	    pstmt1.executeUpdate();
	    pstmt1.close();

	    String sql2 = "DELETE FROM catalogo_riviste WHERE codice_ISBN = ?";
	    PreparedStatement pstmt2 = conn.prepareStatement(sql2);
	    pstmt2.setInt(1, isbn);
	    pstmt2.executeUpdate();
	    pstmt2.close();
	}
	
	//ricerca di un elemento attraverso il codice ISBN
	public void ricercaElementoIsbn(String isbn) throws SQLException {
		String sql = "SELECT * FROM catalogo_libri WHERE codice_ISBN = " + isbn +
                " UNION " +
                " SELECT codice_ISBN, titolo, anno_pubblicazione, numero_pagine, NULL as autore, NULL as genere FROM catalogo_riviste WHERE codice_ISBN = " + isbn;

		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {
			do {
				String codiceISBN = rs.getString("codice_ISBN");
				String titolo = rs.getString("titolo");
				int annoPubblicazione = rs.getInt("anno_pubblicazione");
				int numeroPagine = rs.getInt("numero_pagine");
				String autore = rs.getString("autore");
				String genere = rs.getString("genere");

				if(autore != null && genere != null) {
					Libri l = new Libri(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
					System.out.println(l + "\n");
				}else {
					Riviste r = new Riviste(codiceISBN, titolo, annoPubblicazione, numeroPagine, Periodicity.SETTIMANALE);
					System.out.println(r + "\n");
				}
			}while (rs.next());
		}else {
			System.out.println("Nessun risultato.\n");
		}
	}
	
	//ricerca di un elemento attraverso l'anno di pubblicazione
	public void ricercaElementoAnnoPubblicazione(int anno_pubblicazione) throws SQLException {
		String sql = "SELECT * FROM catalogo_libri WHERE anno_pubblicazione = " + anno_pubblicazione +
                " UNION " +
                " SELECT codice_ISBN, titolo, anno_pubblicazione, numero_pagine, NULL as autore, NULL as genere FROM catalogo_riviste WHERE anno_pubblicazione = " + anno_pubblicazione;

		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {
			do {
				String codiceISBN = rs.getString("codice_ISBN");
				String titolo = rs.getString("titolo");
				int annoPubblicazione = rs.getInt("anno_pubblicazione");
				int numeroPagine = rs.getInt("numero_pagine");
				String autore = rs.getString("autore");
				String genere = rs.getString("genere");

				if(autore != null && genere != null) {
					Libri l = new Libri(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
					System.out.println(l + "\n");
				}else {
					Riviste r = new Riviste(codiceISBN, titolo, annoPubblicazione, numeroPagine, Periodicity.MENSILE);
					System.out.println(r + "\n");
				}
			}while (rs.next());
		}else {
			System.out.println("Nessun risultato.\n");
		}
	}
	
	//ricerca di un elemento attraverso il nome dell'autore
	public void ricercaLibroAutore(String autore) throws SQLException {
		String sql = "SELECT * FROM catalogo_libri WHERE autore = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, autore);

	    ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			do {
				String codiceISBN = rs.getString("codice_ISBN");
				String titolo = rs.getString("titolo");
				int annoPubblicazione = rs.getInt("anno_pubblicazione");
				int numeroPagine = rs.getInt("numero_pagine");
				String autoreLibro = rs.getString("autore");
				String genere = rs.getString("genere");
				
				Libri l = new Libri(codiceISBN, titolo, annoPubblicazione, numeroPagine, autoreLibro, genere);
				System.out.println(l + "\n");
			}while (rs.next());
		}else {
			System.out.println("Nessun risultato.\n");
		}
	}
	
	//ricerca di un elemento attraverso il titolo del libro
	public void ricercaElementoTitolo(String titolo) throws SQLException {
		String sql = "SELECT * FROM catalogo_libri WHERE titolo = ?" +
                " UNION " +
                "SELECT codice_ISBN, titolo, anno_pubblicazione, numero_pagine, NULL as autore, NULL as genere FROM catalogo_riviste WHERE titolo = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titolo);
		pstmt.setString(2, titolo);

		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			do {
				String codiceISBN = rs.getString("codice_ISBN");
				String titoloLibro = rs.getString("titolo");
				int annoPubblicazione = rs.getInt("anno_pubblicazione");
				int numeroPagine = rs.getInt("numero_pagine");
				String autore = rs.getString("autore");
				String genere = rs.getString("genere");

				if(autore != null && genere != null) {
					Libri l = new Libri(codiceISBN, titoloLibro, annoPubblicazione, numeroPagine, autore, genere);
					System.out.println(l + "\n");
				}else {
					Riviste r = new Riviste(codiceISBN, titoloLibro, annoPubblicazione, numeroPagine, Periodicity.SEMESTRALE);
					System.out.println(r + "\n");
				}
			}while (rs.next());
		}else {
			System.out.println("Nessun risultato.\n");
		}
	}
	
	//ricerca di un elemento in prestito
	public void ricercaElementiInPrestito(int numero_tessera) throws SQLException {
		String sql = "SELECT *\n"
				+ "FROM prestito p\n"
				+ "INNER JOIN utenti u ON p.utente = u.numero_tessera\n"
				+ "WHERE u.numero_tessera = " + numero_tessera;
	    
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			String titoloLibro = rs.getString("titolo");
			
			ElementiCatalogo el = new ElementiCatalogo(titoloLibro);
			System.out.println(el);
		}else {
			System.out.println("L'utente con questo numero tessera non ha preso nessun libro in prestito.");
		}
	}
	
}
