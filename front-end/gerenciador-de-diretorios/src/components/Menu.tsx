import './Menu.css'

interface MenuProps {
    onChangeDirectory: () => void
}

const Menu = ({onChangeDirectory}: MenuProps) => {
  return (
    <div className="menu-container">
    <button onClick={onChangeDirectory} className="back-button">Voltar ao diretório anterior</button>
    <div className="options-add-container">
        <button className="add-file-button">
            <img 
                src="./../../public/images/icone-adicionar-arquivo.png" 
                alt="ícone de adicionar arquivo" 
                className="add-file-icon"
            />
        </button>
        <button className="add-folder-button">
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