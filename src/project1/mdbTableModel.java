/*Programmer Name: Terence Jordan
 *10 May 2006
 



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import javax.swing.JOptionPane;

public class mdbTableModel extends AbstractTableModel
{
  public mdbTableModel()
  {
    try
    {
      jbInit();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  private int numberOfRows;

	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private Statement statement;
	private Connection connection;


	private boolean isConnected = false;

	private String TableName;

	public mdbTableModel(String DatabaseURL,String User,String Password,String Query)throws Exception
	{
		
		 String url = "jdbc:mysql://localhost:3306/rakedomanagement";
			
			connection = DriverManager.getConnection(url,"root","");
		
		
		connection=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver " +
	            "(*.mdb)};"+"DBQ=D:\\database\\a.mdb","ayets","setonji04");
		System.out.println("shsdhshsh");
		
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String ConnDriver ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";

			ConnDriver += DatabaseURL.trim () + ";DriverID=22;READONLY=true}";

			connection = DriverManager.getConnection (ConnDriver,User,Password);

			statement = connection.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE,
												ResultSet.CONCUR_UPDATABLE);

			isConnected = true;

		    setQuery(Query);
	}

	public Class getColumnClass( int column ) throws IllegalStateException
   	{

      if ( !isConnected )
         throw new IllegalStateException( "Not Connected to Database" );


      try
      {
         String className = metaData.getColumnClassName( column + 1 );


         return Class.forName( className );
      }
      catch ( Exception exception )
      {
         exception.printStackTrace();
      }

      return Object.class;
  	}

   	public int getColumnCount() throws IllegalStateException
   	{

      if ( !isConnected )
         throw new IllegalStateException( "Not Connected to Database" );


      try
      {
         return metaData.getColumnCount();
      }
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      }

      return 0;
   	}

   	public String getColumnName( int column ) throws IllegalStateException
   	{

      if ( !isConnected )
         throw new IllegalStateException( "Not Connected to Database" );


      try
      {
         return metaData.getColumnName( column + 1 );
      }
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      }

      return "";
  	 }
  	public int getRowCount() throws IllegalStateException
   	{

      if ( !isConnected )
         throw new IllegalStateException( "Not Connected to Database" );

      return numberOfRows;
   	}

	public Object getValueAt( int row, int column )
      throws IllegalStateException
   	{

      if ( !isConnected )
         throw new IllegalStateException( "Not Connected to Database" );


      try
      {
         resultSet.absolute( row + 1 );
         return resultSet.getObject( column + 1 );

      }
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      }

      return "";
   	}

   	public void setQuery( String query )
      throws SQLException, IllegalStateException
   	{

      if ( !isConnected)
         throw new IllegalStateException( "Not Connected to Database" );


      resultSet = statement.executeQuery( query );


      metaData = resultSet.getMetaData();


      resultSet.last();
      numberOfRows = resultSet.getRow();


      fireTableStructureChanged();
   	}

   	public void CloseConnections() throws IllegalStateException
   	{
   		if (!isConnected)
   		throw new IllegalStateException("Not Connected to Database");
   		try
   		{
   			connection.close ();
   			statement.close ();
   		}
   		catch(Exception ex)
   		{
   			ex.printStackTrace ();
   		}
   	}

	public void Edit(String Query)
	{
		try
		{
			statement.execute (Query);

			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error in transaction");
			
		}

	}

	public String getTableName(int Column)
	{
		try
		{
			return metaData.getTableName (Column);

		}
		catch(Exception ex)
		{
			ex.printStackTrace ();
		}

		return "";
	}

  private void jbInit()
      throws Exception
  {
  }
}
*/