import Directory from '../models/Directory'
import './Menu.css'

interface MenuProps {
    actualDirectory: Directory
    onChangeDirectory: () => void
    onAddDirectory:(name: string, superDirectoryID: string) => void
    onAddFile:(name: string, superDirectoryID: string) => void
}

const Menu = ({onChangeDirectory}: MenuProps) => {
  return (
    <div className="menu-container">
        <button onClick={onChangeDirectory} className="back-button">Voltar ao diretório anterior</button>
        <div className="options-add-container">
            <button className="add-file-button" title="Criar arquivo">
                <img 
                    src="./../../public/images/icone-adicionar-arquivo.png" 
                    alt="ícone de adicionar arquivo" 
                    className="add-file-icon"
                />
            </button>
            <button className="add-folder-button" title="Criar pasta">
                <img 
                    src="./../../public/images/icone-adicionar-pasta.png" 
                    alt="ícone de adicionar pasta"
                    className="add-folder-icon"
                />
            </button>
        </div>
    </div>
  )
}

export default Menu