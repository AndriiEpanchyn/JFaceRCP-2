package actions.menuFileActions;

import org.eclipse.jface.action.Action;

import jface.AppWindow;
import jface.SessionManager;
import savers.FileReadManager;

public class OpenFileAction extends Action {
    AppWindow _window;

    public OpenFileAction(AppWindow window) {
	_window = window;
	setText("Open file \tCtrl+O");
	setToolTipText("Open file");
    }

    public void run() {
	_window.clearFields();
	FileReadManager.execute(_window);
	_window.getShell().setText("JFace application:  " + SessionManager.getSession().fileName);
	_window.reassignTableInput();
	_window.redrawAll();
    }
}
