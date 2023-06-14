package controller;

public abstract class BaseController {
    protected SceneManager sceneManager;
    protected static String loginInstanciado;
    
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
    
    public String getLoginInstanciado(){
        return loginInstanciado;
    }
    
    public void setLoginInstanciado(String loginInstanciado){
        this.loginInstanciado = loginInstanciado;
    }
}
