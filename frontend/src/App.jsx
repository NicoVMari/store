import React, { useState, useEffect } from 'react';
import './App.css';

const App = () => {
  const [data, setData] = useState([]);
  const [currentSection, setCurrentSection] = useState('products');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [customerOrders, setCustomerOrders] = useState([]);  // Aggiungi lo stato per gli ordini
  const [selectedCustomer, setSelectedCustomer] = useState(null); // Cliente selezionato

  // Funzione per caricare i dati in base alla sezione
  const loadData = (section) => {
    setLoading(true);
    setError(null);
    
    // Resetta gli ordini e il cliente selezionato quando si cambia sezione
    setCustomerOrders([]);
    setSelectedCustomer(null);

    let url = '';
    switch (section) {
      case 'products':
        url = 'http://localhost:8080/product/allproducts';
        break;
      case 'customers':
        url = 'http://localhost:8080/customer/allcustomers';
        break;
      case 'holidays':
        url = 'http://localhost:8080/holiday/allholidays';
        break;
      case 'orders':
        url = 'http://localhost:8080/order/allorders';
        break;
      case 'suppliers':
        url = 'http://localhost:8080/supplier/allsuppliers';
        break;
      default:
        setLoading(false);
        setError('Sezione non valida');
        return;
    }

    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        setData(data);
        setLoading(false);
        setCurrentSection(section);
      })
      .catch((error) => {
        console.error('Errore nel caricamento dei dati:', error);
        setError('Errore nel caricare i dati');
        setLoading(false);
      });
  };

  // Funzione per caricare gli ordini di un cliente specifico
  const loadCustomerOrders = (customerName) => {
    setLoading(true);
    setError(null);
    setSelectedCustomer(customerName); // Imposta il cliente selezionato

    // Carica gli ordini per il cliente selezionato
    const url = `http://localhost:8080/customerorder/view?customerName=${encodeURIComponent(customerName)}`;

    fetch(url)
      .then((response) => response.json())
      .then((orders) => {
        setCustomerOrders(orders);
        setLoading(false);
      })
      .catch((error) => {
        console.error('Errore nel caricamento degli ordini:', error);
        setError('Errore nel caricare gli ordini del cliente');
        setLoading(false);
      });
  };

  // Funzione per nascondere gli ordini
  const hideOrders = () => {
    setSelectedCustomer(null);
    setCustomerOrders([]);
  };

  useEffect(() => {
    loadData('products');
  }, []);

  return (
    <div className="App">
      <header>
        <h1>Store</h1>
        <nav>
          <button onClick={() => loadData('products')}>Prodotti</button>
          <button onClick={() => loadData('customers')}>Clienti</button>
          <button onClick={() => loadData('holidays')}>Vacanze</button>
          <button onClick={() => loadData('orders')}>Ordini</button>
          <button onClick={() => loadData('suppliers')}>Fornitori</button>
        </nav>
      </header>

      <main>
        {loading && <p>Caricamento...</p>}
        {error && <p style={{ color: 'red' }}>{error}</p>}

        <div className="data-container">
          {data.length > 0 ? (
            <table>
              <thead>
                <tr>
                  {currentSection === 'products' && (
                    <>
                      <th>ID Prodotto</th>
                      <th>Nome Prodotto</th>
                      <th>Prezzo</th>
                      <th>Fornitore</th>
                    </>
                  )}
                  {currentSection === 'customers' && (
                    <>
                      <th>ID Cliente</th>
                      <th>Nome Cliente</th>
                      <th>Indirizzo</th>
                      <th>Email</th>
                    </>
                  )}
                  {currentSection === 'holidays' && (
                    <>
                      <th>ID Vacanza</th>
                      <th>Nome Vacanza</th>
                      <th>Data Vacanza</th>
                      <th>Descrizione</th>
                    </>
                  )}
                  {currentSection === 'orders' && (
                    <>
                      <th>ID Ordine</th>
                      <th>ID Cliente</th>
                      <th>Data Ordine</th>
                      <th>Totale</th>
                    </>
                  )}
                  {currentSection === 'suppliers' && (
                    <>
                      <th>ID Fornitore</th>
                      <th>Nome Fornitore</th>
                      <th>Contatti</th>
                    </>
                  )}
                </tr>
              </thead>
              <tbody>
                {data.map((item, index) => (
                  <tr key={index}>
                    {currentSection === 'products' && (
                      <>
                        <td>{item.id}</td>
                        <td>{item.productName}</td>
                        <td>€{item.price}</td>
                        <td>{item.supplier ? item.supplier.supplierName : 'N/A'}</td>
                      </>
                    )}

                    {currentSection === 'customers' && (
                      <>
                        <td>{item.id}</td>
                        <td>
                          {/* Clicca sul nome del cliente per caricare gli ordini */}
                          <a
                            href="#"
                            onClick={() => loadCustomerOrders(item.name)}
                          >
                            {item.name}
                          </a>
                        </td>
                        <td>{item.address}</td>
                        <td>{item.email}</td>
                      </>
                    )}

                    {currentSection === 'holidays' && (
                      <>
                        <td>{item.id}</td>
                        <td>{item.holidayName}</td>
                        <td>{item.holidayDate}</td>
                        <td>{item.description}</td>
                      </>
                    )}

                    {currentSection === 'orders' && (
                      <>
                        <td>{item.id}</td>
                        <td>{item.customer.name}</td>
                        <td>{item.orderDate}</td>
                        <td>€{item.total}</td>
                      </>
                    )}

                    {currentSection === 'suppliers' && (
                      <>
                        <td>{item.id}</td>
                        <td>{item.supplierName}</td>
                        <td>{item.contacts}</td>
                      </>
                    )}
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <p>Nessun dato disponibile.</p>
          )}

          {/* Se sono stati selezionati gli ordini di un cliente, mostra gli ordini */}
          {selectedCustomer && customerOrders.length > 0 && (
            <div>
              <h2 className="order-title">Ordini di {selectedCustomer}</h2>
              <table>
                <thead>
                  <tr>
                    <th>ID Ordine</th>
                    <th>Nome Prodotto</th>
                    <th>Quantità</th>
                    <th>Prezzo Unitario</th>
                    <th>Totale Prodotto</th>
                    <th>Totale Ordine</th>
                  </tr>
                </thead>
                <tbody>
                  {customerOrders.map((order, index) => (
                    <tr key={index}>
                      <td>{order.idOrder}</td>
                      <td>{order.productName}</td>
                      <td>{order.quantity}</td>
                      <td>€{order.unitPrice}</td>
                      <td>€{order.totalProductPrice}</td>
                      <td>€{order.totalOrderPrice}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
              <button onClick={hideOrders}>Nascondi Ordini</button>
            </div>
          )}
        </div>
      </main>
    </div>
  );
};

export default App;
