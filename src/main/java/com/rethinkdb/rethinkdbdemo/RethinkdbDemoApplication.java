package com.rethinkdb.rethinkdbdemo;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RethinkdbDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RethinkdbDemoApplication.class, args);
	}

	public static final RethinkDB r = RethinkDB.r;

	@Override
	public void run(String... args) throws Exception {
		Connection conn = r.connection().hostname("localhost").port(28015).connect();

		Cursor<ChangePersonResponse> changeCursor = r.db("test").table("person").changes().run(conn, ChangePersonResponse.class);
		for (ChangePersonResponse change : changeCursor) {
			if (change.getNew_val() != null && change.getOld_val() == null) {
				System.out.println("Added: " + change.getNew_val().getName() + " "
						+ change.getNew_val().getLastName()
				);
			}
		}
	}
}
