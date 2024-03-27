import requests
import csv

HOST = "http://localhost:8000"


def main():

	with open("bugs.csv", "w", newline="") as csvfile:
		csv_writer = csv.writer(csvfile, delimiter=",", quotechar= '"')
		csv_writer.writerow(["id","status","package", "summary"])

		next_url = f"{HOST}/bugs"

		while next_url:
			# makes HTTP GET request
			response = requests.get(next_url)
			# parses the response (.content vs .text vs .json())
			json_resp = response.json()
			
			for bug in json_resp["results"]:
				csv_writer.writerow([bug["id"], bug["status"], bug["package"], bug["summary"]])

			next_url = json_resp["next"]


	# TODO: parse bugs 

if __name__ == '__main__':
	main()
