require("dotenv").config();
const express = require("express");
const mysql = require("mysql2");
const bodyParser = require("body-parser");

const app = express();
const port = 3000;

app.use(bodyParser.json());

// Koneksi ke MySQL (phpMyAdmin)
const db = mysql.createConnection({
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME,
    port: process.env.DB_PORT
});

// Cek koneksi database
db.connect(err => {
    if (err) {
        console.error("❌ Database connection failed: " + err.stack);
        return;
    }
    console.log("✅ Connected to MySQL Database.");
});

// **1. Get All Movies (100 Data, Custom Order)**
app.get("/allmovie", (req, res) => {
    let orderBy = req.query.orderBy || "movies"; // Default order by title
    let orderType = req.query.orderType || "ASC"; // Default ascending
    let query = `SELECT movies, one_line FROM movies ORDER BY ?? ${orderType} LIMIT 100`;

    db.query(query, [orderBy], (err, results) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json(results);
    });
});

// **2. Get Movie Detail by title**
app.get("/movie-detail/:title", (req, res) => {
    const movieTitle = req.params.title;
    
    const sql = `SELECT movies AS title, year, genre, rating, one_line AS description, 
                        stars, votes, runtime, gross 
                 FROM movies 
                 WHERE movies = ?`;
    
    db.query(sql, [movieTitle], (err, result) => {
        if (err) {
            return res.status(500).json({ error: err.message });
        }
        if (result.length === 0) {
            return res.status(404).json({ message: "Movie not found" });
        }
        res.json(result[0]);
    });
});

// **3. Add New Movie**
app.post("/add-movie", (req, res) => {
    let { movies, one_line, year, genre, rating, stars, votes, runtime, gross } = req.body;

    // Cek apakah film dengan judul yang sama sudah ada
    let checkQuery = `SELECT * FROM movies WHERE movies = ?`;
    db.query(checkQuery, [movies], (err, result) => {
        if (err) return res.status(500).json({ error: err.message });

        // Jika film sudah ada, kirim respon error
        if (result.length > 0) {
            return res.status(400).json({ message: "Movie already exists", movie: movies });
        }

        // Jika tidak ada duplikasi, lakukan INSERT
        let insertQuery = `INSERT INTO movies (movies, one_line, year, genre, rating, stars, votes, runtime, gross) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)`;
        db.query(insertQuery, [movies, one_line, year, genre, rating, stars, votes, runtime, gross], (err, result) => {
            if (err) return res.status(500).json({ error: err.message });

            res.json({ message: "Movie added successfully", movie: movies });
        });
    });
});


// **4. Update Movie by ID**
app.put("/update-movie/:title", (req, res) => {
    let updates = [];
    let values = [];

    // Loop melalui body untuk melihat field mana yang ingin diupdate
    for (let key in req.body) {
        updates.push(`${key} = ?`);
        values.push(req.body[key]);
    }

    // Jika tidak ada data yang dikirim, hentikan proses
    if (updates.length === 0) {
        return res.status(400).json({ message: "No fields to update" });
    }

    // Tambahkan judul movie sebagai kondisi WHERE
    values.push(req.params.title);

    let updateQuery = `UPDATE movies SET ${updates.join(", ")} WHERE movies = ?`;

    db.query(updateQuery, values, (err, result) => {
        if (err) return res.status(500).json({ error: err.message });

        if (result.affectedRows === 0) {
            return res.status(404).json({ message: "Movie not found" });
        }

        res.json({ message: "Movie updated successfully", movie: req.params.title });
    });
});



// **5. Delete Movie by ID**
app.delete("/delete-movie/:title", (req, res) => {
    let query = `DELETE FROM movies WHERE movies = ?`;

    db.query(query, [req.params.title], (err, result) => {
        if (err) return res.status(500).json({ error: err.message });
        if (result.affectedRows === 0) return res.status(404).json({ message: "Movie not found" });

        res.json({ message: "Movie deleted successfully", movie: req.params.title });
    });
});

// **Cek API Status**
app.get("/", (req, res) => {
    res.json({ message: "API is running!" });
});

// **Jalankan Server**
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
