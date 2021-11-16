# GestioneContatti
Progetto finale Epicode-BE
********************************************************Italian**************************************************************
L'obiettivo del progetto è quello di creare un portale gestionale dove è possibile monitorare/creare/modificare/eliminare fatture e clienti con la possibilità di cercare i clienti per:
-Fatturato annuale 
-Parte della ragione sociale del cliente  
-Data di ultimo contatto
-Data di inserimento del cliente
Oppure ordinarli per:
-Ragione Sociale
-Fatturato Annuale

Mentre per quanto riguarda le fatture è possibile cercarle per:
-Cliente
-Stato della fattura,la quale può essere di vari tipi:
Pagata
Non Pagata
Pagata in ritardo
Non Gestita
-Data o anno della fattura  
-O Tramite un range di importo delle fatture

All'interno del CRUD ho già inserito
-2 File .csv che popoleranno la rispettive tabelle dei comuni e delle province italiane(I file sono inseriti all'interno
della cartella "resources" dentro a "csv" )
-1 User
-20 Indirizzi
-20 Clienti
-20 Fatture 
E' necessario togliere i commenti all'interno del crud, impostare l'application property in create e
inserire i dati necessari affinchè si possa connettere correttamente al vostro database

Ho anche fornito una collection di chiamate postman ai metodi CRUD con il body json già compilato.

Per quanto riguarda la parte HTML, una volta raggiunta la porta localhost:8080 in browser vi ritroverete nell'homepage
principale dove sarà possibile loggare con l'utente già inserito in database il quale possiede i seguenti dati:
username: admin
password: admin
Oppure crearne uno nuovo nella sezione SIGN UP
Dopo aver fatto il signup oppure il login potrete:
Gestire le fatture:
-Visualizzare la lista 
-Cercarle per cliente,stato,data,anno,range
-Creare una nuova fattura 
Gestire i clienti:
-Visualizzare la lista
-Cercarli per fatturato annuale, parte della ragione sociale del cliente, data di ultimo contatto,data di inserimento del cliente
-Ordinarli per ragione sociale, fatturato annuale
-Creare un nuovo cliente
*****************************************************English*****************************************************************
The main goal of the project is to create a management portal where you can monitor / create / modify / delete invoices and customers with the ability to search for customers to:
-Annual turnover 
-Part of the customer's company name  
-Date of last contact
-Date of insertion of the customer
Or sort them by:
-Company Name
-Annual Turnover


While as far as invoices are concerned, you can search for them by:
-Customer
-Status of the invoice, which can be of various types:
Paid
Unpaid
Paid late
Unmanaged
-Date or year of invoice  
-Or Via an invoice amount range

Inside the CRUD I've already inserted
-2 files .csv that will populate the respective tables of Italian municipalities and provinces (The files are inside
of the "resources" folder, inside "csv")
-1 User
-20 Addresses
-20 Customers
-20 Invoices 
It's necessary to remove the comments inside the crud, set the application property in create and
enter the necessary data so that it can be successfully connected to your database

I also provided a collection of postman calls to CRUD methods with the body json already compiled.

As for the HTML part, once you reach the localhost:8080 port in the browser you will find yourself on the homepage
main where it will be possible to log in with the user already entered in the database who has the following data:
username: admin
password: admin
Or you can create a new one in the SIGN UP section.
After signing in or logging in, you can:
Manage invoices:
-View the list 
-Search for them by customer,status,date,year,range
-Create a new invoice 
Manage customers:
-View the list
-Search them by annual turnover, part of the customer's company name, date of last contact, date of insertion of the customer
-Sort them by company name, annual turnover
-Create a new customer

**********************************************************French************************************************************
L'objectif du projet est de créer un portail de gestion où il est possible de suivre/créer/modifier/supprimer les factures et les clients avec la possibilité de rechercher des clients par :
-Chiffre d'affaires annuel
-Une partie du nom commercial du client
- Date du dernier contact
-Date d'insertion du client
Ou commandez-les par :
-Nom de l'entreprise
-Chiffre d'affaires annuel

Alors qu'en ce qui concerne les factures il est possible de les rechercher par :
-Client
- Statut de la facture, qui peut être de plusieurs natures :
Payé
Impayé
Payé en retard
Non géré
- Date ou année de la facture
-O À travers une gamme de montants de factures

Au sein du CRUD je suis déjà entré
-2 fichiers .csv qui alimenteront les tableaux respectifs des communes et provinces italiennes (Les fichiers sont insérés à l'intérieur
du dossier "ressources" dans "csv")
-1 utilisateur
-20 adresses
-20 clients
-20 Factures
Il est nécessaire de supprimer les commentaires à l'intérieur du crud, de définir la propriété de l'application dans create et
saisir les données nécessaires pour qu'il puisse se connecter correctement à votre base de données

J'ai également fourni une collection d'appels de facteur aux méthodes CRUD avec le corps json déjà compilé.

Quant à la partie HTML, une fois que vous atteignez le port localhost : 8080 dans le navigateur vous vous retrouverez dans la page d'accueil
main où il sera possible de se connecter avec l'utilisateur déjà inscrit dans la base de données qui dispose des données suivantes :
nom d'utilisateur : administrateur
mot de passe : administrateur
Ou créez-en un nouveau dans la section INSCRIPTION
Après vous être inscrit ou connecté, vous pouvez :
Gérer les factures :
- Voir la liste
-Recherchez-les par client, statut, date, année, plage
-Créer une nouvelle facture
Gérer les clients :
- Voir la liste
-Les rechercher par chiffre d'affaires annuel, partie du nom de l'entreprise du client, date du dernier contact, date d'entrée du client
-Commandez-les par nom d'entreprise, chiffre d'affaires annuel
-Créer un nouveau client



