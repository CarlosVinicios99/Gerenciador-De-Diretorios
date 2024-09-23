import { useState } from 'react'
import './App.css'
import './models/File'
import Directory from './models/Directory'
import File from './models/File'

function App() {

  const [files, setFiles] = useState<File[]>([])

  const [directories, setDirectories] = useState<Directory[]>([])

  const [selectedDirectory, setSelectedDirectory] = useState<Directory>()

  //useEffect para obter o diretório raiz

  //useEffect para buscar o conteúdo do diretório selecionado e alterar o array de files e diretórios

  return (
    <div className="app-content">
      <h1 className="title">Gerenciador De Diretórios</h1>
    </div>
  )
}

export default App
