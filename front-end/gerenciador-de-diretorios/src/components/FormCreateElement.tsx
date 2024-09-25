import React, { useState } from 'react';
import { ElementType } from '../models/ElementType';
import Directory from '../models/Directory';

interface FormCreateElementProps {
    elementType: ElementType
    selectedDirectory: Directory
    onAddElement: (name: string, superDirectoryID: string) => void
    onDisabilityForm: () => void
}

const FormCreateElement = ({ elementType, selectedDirectory, onAddElement, onDisabilityForm }: FormCreateElementProps) => {
    const [elementName, setElementName] = useState<string>("")

    const handleCreateElement = (ev: React.FormEvent) => {
        ev.preventDefault()
        if(elementName && selectedDirectory?.superDirectoryId) {
            onAddElement(elementName, selectedDirectory.superDirectoryId)
            setElementName("")
        }
    };

    return (
        <form onSubmit={handleCreateElement} className="create-element-form">
            <h2>Criar {elementType === ElementType.FILE ? "Arquivo" : "Diretório"}</h2>
            <input 
                type="text" 
                value={elementName} 
                onChange={(e) => setElementName(e.target.value)}
                className="input-name"
            />
            <div className="options-content">
                <button type="button" onClick={onDisabilityForm}>Cancelar</button>
                <button type="submit">Criar</button>
            </div>
        </form>
    );
};

export default FormCreateElement;
