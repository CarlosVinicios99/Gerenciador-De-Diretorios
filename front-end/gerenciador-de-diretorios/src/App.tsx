import { useState } from 'react'
import './App.css'
import './models/File'
import Directory from './models/Directory'
import File from './models/File'
import FileSystemWindow from './components/FileSystemWindow'

function App() {
  return (
    <div className="app-content">
      <h1 className="title">Gerenciador De Diretórios</h1>
      <FileSystemWindow/>
    </div>
  )
}

export default App
