import requests
import csv

HOST = "http://jcssdev.pythonanywhere.com"


def main():

	with open("bugs.csv", "w") as f:
		csv_writer = csv.writer(f, delimiter=",", quotechar='"')
		next_page = f"{HOST}/bugs/"
		while next_page:	
			# makes HTTP GET request
			response = requests.get(next_page)

			# parses the response (.content vs .text vs .json())
			json_response = response.json()

			# iterate over each bug to write it into a file
			for bug in json_response["results"]:
				csv_writer.writerow( [bug["id"], bug["status"], bug["summary"], bug["package"]])

			next_page = json_response["next"]
	
	


	

if __name__ == '__main__':
	main()
