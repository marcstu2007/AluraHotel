package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HuespedController;
import controller.ReservadoController;
import model.Huesped;
import model.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    String[] busqueda = {
			            "Apellido",
			            "Número de reserva"
			        };
			    
			    int seleccion = JOptionPane.showOptionDialog(null, "Buscar por: ", "Titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, busqueda, busqueda[0]);
			    
			    if (seleccion == 0) {
			    	CargarTablaApellido();	
			    }else {
			    	CargarTablaReserva();
			    }
				
			}
		});
		

		
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
			    String[] busqueda = {
			            "Reserva",
			            "Huesped"
			        };
			    
			    int seleccion = JOptionPane.showOptionDialog(null, "Editar registro en: ", "Titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, busqueda, busqueda[0]);
			    
			    if (seleccion == 0) {
			    	EditarReserva();	
			    }else {
			    	EditarHuesped();
			    }
				
			}
		});
		
		
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				  String[] busqueda = {
				            "Reserva",
				            "Huesped"
				        };
				    
				    int seleccion = JOptionPane.showOptionDialog(null, "Eliminar registro en: ", "Titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, busqueda, busqueda[0]);
				    
				    if (seleccion == 0) {
				    	EliminarReserva();	
				    }else {
				    	EliminarHuesped();
				    }
			}
		});
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	private void EliminarReserva() {
		if(tieneFilaElegida(tbReservas)) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila");
            return;
		}
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn())).
		ifPresentOrElse(fila -> {
			ReservadoController reservadoController = new ReservadoController();
			Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
			
			int filasModificadas = reservadoController.Eliminar(id);
			modelo.removeRow(tbReservas.getSelectedRow());
			
			JOptionPane.showMessageDialog(this,
                    String.format("%d item eliminado con éxito!", filasModificadas));
			
		}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
		
	}
	
	private void EliminarHuesped() {
		if(tieneFilaElegida(tbHuespedes)) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila");
            return;
		}
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn())).
		ifPresentOrElse(fila -> {
			HuespedController huespedController = new HuespedController();
			Integer id =Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
			
			int filasModificadas = huespedController.Eliminar(id);
			modeloHuesped.removeRow(tbHuespedes.getSelectedRow());
			
			JOptionPane.showMessageDialog(this,
                    String.format("%d item eliminado con éxito!", filasModificadas));
			
		}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
	}
	
	private void EditarHuesped() {
		if(tieneFilaElegida(tbHuespedes)) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila");
            return;
		}
		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn())).
		ifPresentOrElse(fila -> {
			HuespedController huespedController = new HuespedController();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			
			String Nombre="";
			String Apellido="";
			Date FechaNacimiento = null;
			Integer Nacionalidad=0;
			Integer Telefono=0;
			Integer IdReserva=0;
			Integer Id=0;
			
			try {
				Id = Integer.parseInt(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
				Nombre = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1).toString();
				Apellido = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(),2).toString();
				FechaNacimiento =  formato.parse(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
				int nacionalidad = getIdNacionalidad(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4).toString());
				Nacionalidad = nacionalidad;
				Telefono =Integer.parseInt(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString());  
				IdReserva = Integer.parseInt(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
				
			} catch(ParseException e1) {
				e1.printStackTrace();
			}
			
			System.out.println(Id+" "+Nombre+" "+Apellido+" "+FechaNacimiento+" "+Nacionalidad+" "+ Telefono+" "+IdReserva);
			Huesped huesped = new Huesped(Id, Nombre,Apellido,FechaNacimiento,Nacionalidad, Telefono,IdReserva);
			String resultado = huespedController.Editar(huesped);
			
			if ( isNumeric( resultado) ) {
				JOptionPane.showMessageDialog(null, "La actualización se ha realizado con exito!!!");
				
			}else {
				JOptionPane.showMessageDialog(null, resultado);	
			}
		},() -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
				
	}
	
	private void EditarReserva() {
		if(tieneFilaElegida(tbReservas)) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila");
            return;
		}
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn())).
		ifPresentOrElse(fila -> {
			ReservadoController reservadoController = new ReservadoController();
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			
			Integer id=0;
			Date FechaEntrada = null;
			Date FechaSalida = null;
			Double Valor = 0.0;
			Integer FormaPago =1;
			try {
				id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
				FechaEntrada = formato.parse(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
				FechaSalida = formato.parse(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
				Valor = Double.parseDouble(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
				FormaPago = getTipoPago(modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString());;

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			Reserva reservado = new Reserva(id, FechaEntrada, FechaSalida, Valor, FormaPago);
			String resultado = reservadoController.Editar(reservado);
			
			if ( isNumeric( resultado) ) {
				JOptionPane.showMessageDialog(null, "La actualización se ha realizado con exito!!!");
				
			}else {
				JOptionPane.showMessageDialog(null, resultado);	
			}
			
		}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));

	}
	
    public static boolean isNumeric(String s)
    {
        if (s == null || s.equals("")) {
            return false;
        }
 
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
	
    private boolean tieneFilaElegida(JTable tabla) {
        return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
    }
    
    List<String> Nacionalidad = new ArrayList<String>(Arrays.asList("afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"));
    List<String> TipoPago = new ArrayList<String>(Arrays.asList("Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"));
    
    private int getIdNacionalidad(String nacionalidad) {
    	int conteo=0;
    	for (int i = 0; i <= Nacionalidad.size() - 1; i++) { 		
    		if(Nacionalidad.get(i).equals(nacionalidad)) {
    			System.out.println(i+") "+Nacionalidad.get(i));
    			break;
    		}else {
    			conteo++;	
    		}
    		
    	}
    	return conteo-1;
    }
    
    private String getNombreNacionalidad(int id) {
    	return Nacionalidad.get(id);
    }
    
    private int getTipoPago(String tipoPago) {
    	int conteo=0;
    	for (int i = 0; i <= TipoPago.size() - 1; i++) { 		
    		if(TipoPago.get(i).equals(tipoPago)) {
    			System.out.println(i+") "+TipoPago.get(i));
    			break;
    		}else {
    			conteo++;	
    		}
    	}
    	return conteo-1;
    }
    
    private String getTipoPago(int id) {
    	return TipoPago.get(id);
    }
    
	private void CargarTablaApellido() {
		System.out.println(this.txtBuscar.getText().trim());
			HuespedController huespedController = new HuespedController();

			var huespedController1 = huespedController.buscarApellido(this.txtBuscar.getText());
			LimpiarTabla(modeloHuesped);
			
			
			huespedController1.forEach(huesp -> modeloHuesped.addRow(new Object[] {
					huesp.getId(),
					huesp.getNombre(),
					huesp.getApellido(),
					huesp.getFechaNacimiento(),
					getNombreNacionalidad(huesp.getNacionalidad()),
					huesp.getTelefono(),
					huesp.getIdReserva()
			}));
	
		
	}
	private void CargarTablaReserva() {
		System.out.println(this.txtBuscar.getText().trim());
		ReservadoController reservadoController = new ReservadoController();
		var reservadoController1 = reservadoController.buscarReserva(Integer.parseInt(this.txtBuscar.getText()));
			LimpiarTabla(modelo);
			reservadoController1.forEach(reserv -> modelo.addRow(new Object[] {
					reserv.getId(),
					reserv.getFechaEntrada() ,
					reserv.getFechaSalida(),
					reserv.getValor(),
					getTipoPago(reserv.getFormaPago())					
			}));
	
		
	}
	private void LimpiarTabla(DefaultTableModel modeloTabla) {
		int a = modeloTabla.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        	modeloTabla.removeRow(modeloTabla.getRowCount()-1);
        }
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
