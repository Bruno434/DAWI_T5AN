package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;

public class FrmManteProd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox<Object> cboCategorias;
	JComboBox<Object> cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(323, 26, 89, 24);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox<Object>();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);

		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(220, 106, 102, 14);
		contentPane.add(lblProveedor);

		cboProveedores = new JComboBox<Object>();
		cboProveedores.setBounds(310, 106, 86, 22);
		contentPane.add(cboProveedores);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarProducto();	
			}
		});
		btnBuscar.setBounds(323, 53, 89, 24);
		contentPane.add(btnBuscar);

		llenaCombo();
	}

	void llenaCombo() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		TypedQuery<Categoria> consulta = em.createQuery("select c from Categoria c", Categoria.class);
		List<Categoria> list = consulta.getResultList();
		cboCategorias.addItem("Selccione...");
		for (Categoria c : list) {
			cboCategorias.addItem(c.getIdCat() + "-" + c.getDesc());
		}
		TypedQuery<Proveedor> consulta2 = em.createQuery("select p from Proveedor p", Proveedor.class);
		List<Proveedor> list2 = consulta2.getResultList();
		cboProveedores.addItem("Selccione...");
		for (Proveedor p : list2) {
			cboProveedores.addItem(p.getIdprovedor() + "-" + p.getNombre_rs());
		}
		em.close();
	}

	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Producto> consulta = em.createQuery("select p from Producto p", Producto.class);
		List<Producto> list = consulta.getResultList();
		txtSalida.setText("");
		for (Producto p : list) {
			txtSalida.append("Codigo... : " + p.getId_prod() + "\n");
			txtSalida.append("Nombre... : " + p.getDes_prod() + "\n");
			txtSalida.append("Stock... : " + p.getStk_prod() + "\n");
			txtSalida.append("Precio... : " + p.getPre_prod() + "\n");
			txtSalida.append("Categoria... : " + p.getCategorias().getDesc() + "\n");
			txtSalida.append("Estado... : " + p.getEst_prod() + "\n");
			txtSalida.append("Proveedor... : " + p.getProveedores().getNombre_rs() + "\n");
			txtSalida.append("************************************** \n");
		}
		em.close();
	}

	void registrar() {
		String cod = txtCódigo.getText();
		String desc = txtDescripcion.getText();
		int stck = Integer.parseInt(txtStock.getText());
		double precio = Double.parseDouble(txtPrecio.getText());
		int cate = cboCategorias.getSelectedIndex();
		int est = 1;
		int prov = cboProveedores.getSelectedIndex();

		Producto p = new Producto();
		p.setId_prod(cod);
		p.setDes_prod(desc);
		p.setStk_prod(stck);
		p.setPre_prod(precio);
		p.setIdcategoria(cate);
		p.setEst_prod(est);
		p.setIdprovedor(prov);

		// Proceso de Registro
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		try {
			// ??? registrar
			em.persist(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error");
		}

		em.close();
		JOptionPane.showMessageDialog(this, "Producto registrado");
	}

	void BuscarProducto() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		try {

			Producto p = em.find(Producto.class, txtCódigo.getText());
			if (p == null)
				txtSalida.setText("No existe");
			else {
				txtSalida.setText("Nombre... : "+p.getDes_prod());;
			}
		} catch (Exception e) {
			txtSalida.setText("No existe"+e.getMessage());
		}
		em.close();
	}
}
