import { useState } from 'react'
import Directory from '../models/Directory'
import './Menu.css'
import FormCreateElement from './FormCreateElement'
import { ElementType } from '../models/ElementType'

interface MenuProps {
    actualDirectory: Directory
    onChangeDirectory: () => void
    onAddDirectory:(name: string, superDirectoryID: string) => void
    onAddFile:(name: string, superDirectoryID: string) => void
}

const Menu = ({onChangeDirectory, actualDirectory, onAddDirectory, onAddFile}: MenuProps) => {

    const [isFormCreateFileEnable, setIsFormCreateFileEnable] = useState<boolean>(false)
    const [isFormCreateDirectoryEnable, setIsFormCreateDirectoryEnable] = useState<boolean>(false)

    return (
        <>
            <div className="menu-container">
                <button onClick={onChangeDirectory} className="back-button">Voltar ao diretório anterior</button>
                <div className="options-add-container">
                    <button 
                        onClick={() => setIsFormCreateFileEnable(true)} 
                        className="add-file-button" 
                        title="Criar arquivo"
                    >
                        <img 
                            src="./../../public/images/icone-adicionar-arquivo.png" 
                            alt="ícone de adicionar arquivo" 
                            className="add-file-icon"
                        />
                    </button>
                    <button
                        onClick={() => setIsFormCreateDirectoryEnable(true)} 
                        className="add-folder-button" 
                        title="Criar pasta"
                    >
                        <img 
                            src="./../../public/images/icone-adicionar-pasta.png" 
                            alt="ícone de adicionar pasta"
                            className="add-folder-icon"
                        />
                    </button>
                </div>
            </div>
            {isFormCreateDirectoryEnable 
                ?   (<FormCreateElement 
                        elementType={ElementType.DIRECTORY}
                        onAddElement={onAddDirectory}
                        onDisableForm={() => setIsFormCreateDirectoryEnable(false)}
                        actualDirectory={actualDirectory}
                    />)
                : null
            }
            {isFormCreateFileEnable 
                ?   (<FormCreateElement 
                        elementType={ElementType.FILE}
                        onAddElement={onAddFile}
                        onDisableForm={() => setIsFormCreateFileEnable(false)}
                        actualDirectory={actualDirectory}
                    />)
                : null
            }
        </>
    )
    
}

export default Menu