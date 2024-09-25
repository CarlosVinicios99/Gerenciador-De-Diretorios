import React, { useState } from 'react';
import { ElementType } from '../models/ElementType';
import Directory from '../models/Directory';
import './FormCreateElement.css'

interface FormCreateElementProps {
    elementType: ElementType
    actualDirectory: Directory
    onAddElement: (name: string, superDirectoryID: string) => void
    onDisableForm: () => void
}

const FormCreateElement = ({ elementType, actualDirectory, onAddElement, onDisableForm }: FormCreateElementProps) => {
    const [elementName, setElementName] = useState<string>("")

    const handleCreateElement = (ev: React.FormEvent) => {
        ev.preventDefault()
        if(elementName && actualDirectory?.superDirectoryId) {
            onAddElement(elementName, actualDirectory.superDirectoryId)
            setElementName("")
        }
    };

    return (
        <div className="modal-overlay">
            <form onSubmit={handleCreateElement} className="create-element-form">
                <span className="form-title"> Criar {elementType === ElementType.FILE ? "Arquivo" : "Diretório"}</span>
                <input 
                    type="text" 
                    value={elementName} 
                    onChange={(e) => setElementName(e.target.value)}
                    placeholder="digite o nome"
                    className="input-name"
                />
                <div className="options-container">
                    <button type="button" onClick={onDisableForm} className='cancel-button'>Cancelar</button>
                    <button type="submit" className='create-button'>Criar</button>
                </div>
            </form>
        </div>
    );
};

export default FormCreateElement;
