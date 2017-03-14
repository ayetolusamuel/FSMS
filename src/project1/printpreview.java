/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import project1.DEObjects;
import project1.DEPrint;
import project1.ExtFrame;
import project1.dbODBC;
import project1.DEObjects.DEButton;
import project1.DEObjects.DETextArea;


	private void toPrintRecords() {
		final ExtFrame PrintFrame 				= new ExtFrame();
		PrintFrame.setResizable( false );
		PrintFrame.setTitle( "Print Preview" );
		PrintFrame.getContentPane().setLayout( new java.awt.FlowLayout() );
		DEObjects Objects = new DEObjects();
		final DEObjects.DETextArea PrintPreview = Objects.new DETextArea( 20, 41 );
		PrintFrame.setVisible( true );
		PrintFrame.getContentPane().add( PrintPreview.withScrollbar() );
		PrintPreview.withScrollbar().setPreferredSize( PrintPreview.getPreferredSize().getSize() );
		String Text = "";
		if ( ! ProductName.isVisible() ) {
			Text = "Type Info : " + (String)  AllTypeInfo.getSelectedItem() + "\t" + " \t" + "\n" +
						"\n";
		}
		Text = Text + "Product ID" + " \t" + "Product Name" + " \t\t\t\t\t" + "Quantity" + " \t" + "Unit Price" +"\n";

		Object AllValueOfProductID[]			= ProductTable.getAllValueAtColumn( "ProductID" );
		Object AllValueOfProductName[]		= ProductTable.getAllValueAtColumn( "ProductName" );
		Object AllValueOfQuantity[]			= ProductTable.getAllValueAtColumn( "Quantity" );
		Object AllValueOfUnitPrice[]			= ProductTable.getAllValueAtColumn( "UnitPrice" );

		int RowCount = AllValueOfProductID.length;
		for ( int a = 0; a < RowCount; a++ ) {
			Text = Text + 	(String) AllValueOfProductID[ a ] + " \t " + (String) AllValueOfProductName[ a ] + "\t";
			if ( ((String) AllValueOfProductName[ a ]).length() < 25 )
				Text = Text + "\t\t\t";
			else if ( ((String) AllValueOfProductName[ a ]).length() < 28 )
				Text = Text +"\t" + "\t";
			else if ( ((String) AllValueOfProductName[ a ]).length() < 30 )
				Text = Text +"\t";

			if ( ((String) AllValueOfProductName[ a ]).length() <= 15 )
				Text = Text + "\t";
			else if ( ((String) AllValueOfProductName[ a ]).length() < 11 )
				Text = Text + "\t" + "\t";
			else if ( ((String) AllValueOfProductName[ a ]).length() < 9 )
				Text = Text + "\t" + "\t" + "\t";

			Text = Text + (String) AllValueOfQuantity[ a ] +   " \t\t " + (String) AllValueOfUnitPrice[ a ] +" \n";
		}

		PrintPreview.setText( Text );
		//PrintPreview.setEditable( false );
		DEObjects.DEButton 	OKButton = Objects.new DEButton( "&OK", null ),
										CancelButton = Objects.new DEButton( "&Cancel", null );
		OKButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ) {
				DEPrint.printComponent( PrintPreview );
				PrintFrame.dispose();
			}
		} );
		CancelButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent event ) {
				PrintFrame.dispose();
			}
		} );

		PrintFrame.getContentPane().add( OKButton );
		PrintFrame.getContentPane().add( CancelButton );
		PrintFrame.setSize( PrintFrame.getPreferredSize() );
		PrintFrame.validate();
	}

	public void actionPerformed( ActionEvent event ) {
		System.out.println( event.getActionCommand() );
		String command = event.getActionCommand();
		if ( command.equals( "Validate" ) ) {
			if ( doValidate() )
				toValidate();
		}
		else if ( command.equals( "Edit" ) )
			toEdit();
		else if ( command.equals( "Cancel" ) )
			toCancel();
		else if ( command.equals( "Update" ) )
			toUpdate();
		else if ( command.equals( "Save" ) )
			toSave();
		else if ( command.equals( "Done" ) )
			toDone();
		else if ( command.equals( "Refresh" ) )
			toRefresh();
		else if ( command.equals( "Print Records" ) )
			toPrintRecords();
		else if ( command.equals( "Criteria" ) )  {
			toCriteria();
			ProductName.requestFocus();
		}
	}
	//========================mouseListener============================
	public void mouseClicked( MouseEvent event ) {
		if ( event.getSource() == Quantity )
			toEditQuantity();
		else if ( event.getSource() == UnitPrice )
			toEditUnitPrice();
	}
	public void mouseEntered( MouseEvent event ){}
	public void mouseExited( MouseEvent event ){}
	public void mousePressed( MouseEvent event ){}
	public void mouseReleased( MouseEvent event ){}
	//========================KeyListener============================
		public void keyPressed( KeyEvent event ) {
			if ( event.getKeyCode() == event.VK_ENTER ) {
				if ( doValidate() )
					toValidate();
			}
		}
		public void keyReleased( KeyEvent event ) {}
		public void keyTyped( KeyEvent event ) {}
	//======================ItemListener=============================
	public void itemStateChanged( ItemEvent event ) {
		if ( event.getSource() == AllTypeInfo ) {
			odbc = new dbODBC( TheSystem.getConnection() );
			String SQL = "Select " +
									"Type.TypeID " +
								"From " +
									"[Type] " +
								"Where " +
									"Type.TypeInfo = '" + AllTypeInfo.getSelectedItem() + "' ";
			odbc.executeQuery( SQL );
			if ( odbc.move( "Next" ) ) {
				TypeID.setText( odbc.getString( "TypeID" ) );
				if ( ProductTable.isVisible() )
					doProducts();
			}
			else if ( ! forAddNew.isVisible() && ! forEdit.isVisible() )
				TypeID.setText( "" );
		}
	}
}
*/