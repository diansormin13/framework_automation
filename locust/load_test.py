from locust import HttpUser, task, between

class WebsiteUser(HttpUser):
    wait_time = between(1, 3)  # Waktu tunggu antar request
    host = "http://localhost:3000"  # URL API yang diuji
    stop_timeout = 30  # User akan berhenti setelah 30 detik

    @task
    def test_homepage(self):
        self.client.get("/allmovie")  # Menguji endpoint "/allmovie"